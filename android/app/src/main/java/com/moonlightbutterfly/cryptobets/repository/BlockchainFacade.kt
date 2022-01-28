package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.Bets
import com.moonlightbutterfly.cryptobets.BuildConfig
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import java.math.BigInteger

class BlockchainFacade {
    private val web3 = Web3j.build(HttpService(BuildConfig.INFURA_KEY))
    private lateinit var credentials: Credentials
    private lateinit var contract: Bets

    fun initialize(privateKey: String) {
        credentials = Credentials.create(privateKey)
        contract = Bets.load(
            "0x81cAcAD0044EC9A7585725d3e1642929904dB42c", //Dodać nowy
                web3,
                credentials,
                DefaultGasProvider()
            )
    }

    fun bet(betName: String, option: String, howMuch: Double) {
        contract
            .enter(option, betName, howMuch.etherToWei())
            .send()
    }

    fun getBetPlayerInfo(
        bet: Bet,
    ): BetPlayerInfo {
        return BetPlayerInfo(
            bet,
            isParticipating = contract.isAddressParticipating(credentials.address, bet.title).send(),
            contribution = contract
                .getContributionForAddress(credentials.address, bet.title)
                .send()
                .weiToEther(),
            reward = contract.getRewardForAddress(credentials.address, bet.title).send().weiToEther(),
            didPlayerWin = contract.didAddressWin(credentials.address, bet.title).send(),
            pickedOption = contract.getPickedOptionForAddress(credentials.address, bet.title).send()
        )
    }

    fun getBetsIdentifiers(): List<String> {
        return contract.bets.send() as List<String>
    }

    fun getBet(betTitle: String): Bet {
        val betOptions: List<String> = contract.getBetOptions(betTitle).send() as List<String>
        val minimumEntrance = contract.minimumEntrance().send()
        val isResolved = contract.isResolved(betTitle).send()
        return Bet(
            title = betTitle,
            options = betOptions,
            minimumEntrance = minimumEntrance.weiToEther(),
            isResolved = isResolved
        )
    }

    private fun BigInteger.weiToEther() = this.divide(BigInteger(WEI)).toDouble()
    private fun Double.etherToWei() = BigInteger(this.toString()).times(BigInteger(WEI))

    private companion object {
        const val WEI = "1000000000000000000"
    }

}