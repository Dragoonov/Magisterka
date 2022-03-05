package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.Bets
import com.moonlightbutterfly.cryptobets.BuildConfig
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import org.web3j.abi.FunctionEncoder
import org.web3j.abi.datatypes.Function
import org.web3j.abi.datatypes.Utf8String
import org.web3j.crypto.Credentials
import org.web3j.crypto.RawTransaction
import org.web3j.crypto.TransactionEncoder
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetTransactionCount
import org.web3j.protocol.core.methods.response.EthSendTransaction
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import org.web3j.tx.ManagedTransaction
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Convert
import org.web3j.utils.Numeric
import java.math.BigDecimal
import java.util.*
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

    fun bet(betName: String, option: String, howMuch: Double): CompletableFuture<EthSendTransaction> {
        val ethGetTransactionCount: EthGetTransactionCount = web3.ethGetTransactionCount(
            credentials.address, DefaultBlockParameterName.LATEST
        ).sendAsync().get()
        val nonce = ethGetTransactionCount.transactionCount
        val function = Function(
            "enter",
            listOf(Utf8String(option), Utf8String(betName)),
            Collections.emptyList()
        )
        val txData = FunctionEncoder.encode(function)
        val rawTransaction = RawTransaction.createTransaction(
            nonce,
            ManagedTransaction.GAS_PRICE,
            Contract.GAS_LIMIT,
            contract.contractAddress,
            Convert.toWei(BigDecimal(howMuch), Convert.Unit.ETHER).toBigInteger(),
            txData)
        val signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials)
        val hexValue = Numeric.toHexString(signedMessage)
        return web3.ethSendRawTransaction(hexValue).sendAsync()
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