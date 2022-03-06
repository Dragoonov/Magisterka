package com.moonlightbutterfly.cryptobets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import kotlinx.coroutines.Dispatchers
import org.web3j.protocol.core.methods.response.EthSendTransaction
import java.util.concurrent.CompletableFuture

class SubscribeViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    fun bet(bet: Bet, amount: Double, option: String): CompletableFuture<EthSendTransaction> {
        return blockchainFacade.bet(bet.title, option, amount)
    }

    fun getBet(betTitle: String) = liveData(Dispatchers.IO) {
        emit(blockchainFacade.getBet(betTitle))
    }
}