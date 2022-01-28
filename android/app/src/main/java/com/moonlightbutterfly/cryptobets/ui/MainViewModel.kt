package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import okhttp3.internal.notify

class MainViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    private val _allBets = MutableLiveData(blockchainFacade.getBetsIdentifiers())
    .map { list ->
        list.map { blockchainFacade.getBet(it) }
    }

    val allBets: LiveData<List<Bet>> = _allBets

    val enteredBets = _allBets.map { list ->
        list
            .map { blockchainFacade.getBetPlayerInfo(it) }
            .filter {
                it.isParticipating && !it.bet.isResolved
            }
    }

    val resolvedBets = _allBets.map { list ->
        list
            .map { blockchainFacade.getBetPlayerInfo(it) }
            .filter {
                it.isParticipating && it.bet.isResolved
            }
    }

    fun bet(bet: Bet, amount: Double, option: String) {
        blockchainFacade.bet(bet.title, option, amount)
    }

    fun getBet(betTitle: String) = allBets.value!!.first { it.title == betTitle }
}