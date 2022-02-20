package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.Bets
import com.moonlightbutterfly.cryptobets.BuildConfig
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Convert
import java.math.BigDecimal
import java.util.concurrent.CompletableFuture


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

    fun bet(betName: String, option: String, howMuch: Double): CompletableFuture<TransactionReceipt> {
//        val ethGetTransactionCount: EthGetTransactionCount = web3.ethGetTransactionCount(
//            credentials.address, DefaultBlockParameterName.LATEST
//        ).sendAsync().get()
//        val nonce = ethGetTransactionCount.transactionCount
//        val gasPrice = DefaultGasProvider.GAS_PRICE
//        val gasLimit = DefaultGasProvider.GAS_LIMIT
//        val to = contract.contractAddress
//        val value = howMuch
//        val data =
//        RawTransaction.createTransaction(nonce, gasPrice, gasLimit, to, "")
//        web3.ethSendRawTransaction()
        return contract
            .enter(option, betName, Convert.toWei(BigDecimal(howMuch), Convert.Unit.ETHER).toBigInteger())
            .sendAsync()
    }

    fun getBetPlayerInfo(
        bet: Bet,
    ): BetPlayerInfo {
        return BetPlayerInfo(
            bet,
            isParticipating = contract.isAddressParticipating(credentials.address, bet.title)
                .send(),
            contribution = Convert.fromWei(BigDecimal(contract
                .getContributionForAddress(credentials.address, bet.title)
                .send()), Convert.Unit.ETHER).toDouble(),
            reward = Convert.fromWei(BigDecimal(contract
                .getRewardForAddress(credentials.address, bet.title)
                .send()), Convert.Unit.ETHER).toDouble(),
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
            minimumEntrance = Convert.fromWei(BigDecimal(minimumEntrance), Convert.Unit.ETHER).toDouble(),
            isResolved = isResolved
        )
    }

}