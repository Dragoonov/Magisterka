package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.BuildConfig
import com.moonlightbutterfly.cryptobets.Lottery
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import com.moonlightbutterfly.cryptobets.models.Option
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import java.math.BigInteger

class BlockchainFacade {
    private val web3 = Web3j.build(HttpService(BuildConfig.INFURA_KEY))
    private lateinit var credentials: Credentials
    private lateinit var lotteryContracts: List<Lottery>

    fun initialize(privateKey: String, publicKey: String, addresses: List<String>) {
        credentials = Credentials.create(privateKey, publicKey)
        lotteryContracts = addresses.map {
            Lottery.load(
                it,
                web3,
                credentials,
                DefaultGasProvider()
            )
        }
    }

    fun bet(identifier: String, option: Option, howMuch: Double) {
        lotteryContracts
            .first { it.contractAddress == identifier }
            .enter(BigInteger.valueOf(option.value.toLong()))
            .send()
    }

    fun getBetPlayerInfo(
        bet: Bet,
        betIdentifier: String
    ): BetPlayerInfo {
        val contract = lotteryContracts.first { it.contractAddress == betIdentifier }
        val optionValue = contract.getPickedOptionForAddress(credentials.address).send().toInt()
        val optionName = contract.getStringRepresentation(BigInteger(optionValue.toString())).send()
        return BetPlayerInfo(
            bet,
            isParticipating = contract.isAddressParticipating(credentials.address).send(),
            contribution = contract
                .getContributionForAddress(credentials.address)
                .send()
                .weiToEther(),
            reward = contract.getRewardForAddress(credentials.address).send().weiToEther(),
            didPlayerWin = contract.didAddressWin(credentials.address).send(),
            pickedOption = Option(optionValue, optionName)
        )
    }

    fun getBet(betIdentifier: String): Bet {
        val contract = lotteryContracts.first { it.contractAddress == betIdentifier }
        val name = contract.name().send()
        val optionsAmount = contract.optionsAmount.send().toInt()
        val options = mutableListOf<Option>()
        for (i in 1..optionsAmount) {
            options.add(Option(i, contract.getStringRepresentation(BigInteger(i.toString())).send()))
        }
        val minimumEntrance = contract.minimumEntrance().send()
        val isResolved = contract.resolved().send()
        return Bet(
            title = name,
            options = options,
            minimumEntrance = minimumEntrance.weiToEther(),
            identifier = betIdentifier,
            isResolved = isResolved
        )
    }

    private fun BigInteger.weiToEther() = this.divide(BigInteger(WEI)).toDouble()

    private companion object {
        const val WEI = "1000000000000000000"
    }

}