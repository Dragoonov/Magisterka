package com.moonlightbutterfly.testapp

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.protocol.core.methods.response.TransactionReceipt

import org.web3j.tx.TransactionManager

import org.web3j.tx.response.PollingTransactionReceiptProcessor

import org.web3j.tx.response.TransactionReceiptProcessor

import org.web3j.tx.RawTransactionManager

import org.web3j.abi.FunctionEncoder
import org.web3j.abi.datatypes.Function
import org.web3j.abi.datatypes.Type

import org.web3j.abi.datatypes.Uint
import org.web3j.abi.datatypes.Utf8String
import org.web3j.protocol.Service
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.websocket.WebSocketService
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*


class Blockchain {
    private val web3 = Web3j.build(HttpService("https://rinkeby.infura.io/v3/08a52ad2a7c448abafef1251900d798c"))
    private lateinit var credentials: Credentials
    private lateinit var contract: Test

    fun initialize(privateKey: String) {
        credentials = Credentials.create(privateKey)
        contract = Test.load(
            "0x0A7e9B3a2e8066846682F57a23F1DE53E9062b29", //Dodać nowy
            web3,
            credentials,
            DefaultGasProvider()
        )
    }

    fun sendFunds() {
        val receipt = Transfer.sendFunds(web3, credentials, contract.contractAddress, BigDecimal.valueOf(0.001), Convert.Unit.ETHER)
            .sendAsync().get()
        receipt.isStatusOK
    }

    fun balance() {
        val balance = web3.ethGetBalance(credentials.address, DefaultBlockParameterName.LATEST).sendAsync().get()
        Log.v("Kurwa", balance.balance.toString())
    }


    fun chuj() {
        CoroutineScope(Dispatchers.IO).launch {
            val function = Function(
                "enterNotPayable",
                listOf(Utf8String("Chuj")),
                Collections.emptyList()
            )
            val txData = FunctionEncoder.encode(function)
            val txManager: TransactionManager = RawTransactionManager(web3, credentials)
            val txHash = txManager.sendTransaction(
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                contract.contractAddress,
                txData,
                BigInteger.ZERO
            ).transactionHash
            val receiptProcessor: TransactionReceiptProcessor = PollingTransactionReceiptProcessor(
                web3,
                TransactionManager.DEFAULT_POLLING_FREQUENCY,
                TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH
            )
            val txReceipt = receiptProcessor.waitForTransactionReceipt(txHash)
            txReceipt.gasUsed
        }
    }

}