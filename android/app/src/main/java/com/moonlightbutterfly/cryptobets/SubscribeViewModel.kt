package com.moonlightbutterfly.cryptobets

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscribeViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    fun bet(bet: Bet, amount: Double, option: String, action: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            blockchainFacade.bet(bet.title, option, amount).whenComplete { transactionReceipt, throwable ->
                Log.v("CryptoBets", transactionReceipt.transactionHash)
                Log.v("CryptoBets", transactionReceipt.error.message)
                CoroutineScope(Dispatchers.Main).launch {
                    action()
                }
            }
        }
    }

    fun getBet(betTitle: String) = liveData(Dispatchers.IO) {
        emit(blockchainFacade.getBet(betTitle))
    }
}