package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class MainViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    private val _allBets = liveData(Dispatchers.IO) {
        val list = blockchainFacade.getBetsIdentifiers()
            .map { blockchainFacade.getBet(it) }
            .filter { !it.isResolved }
        emit(list)
    }

    val allBets: LiveData<List<Bet>> = _allBets

    val enteredBets = liveData(Dispatchers.IO) {
        val list = blockchainFacade.getBetsIdentifiers()
            .map { blockchainFacade.getBet(it) }
            .map { blockchainFacade.getBetPlayerInfo(it) }
            .filter { it.isParticipating && !it.bet.isResolved }
        emit(list)
    }

    val resolvedBets = liveData(Dispatchers.IO) {
        val list = blockchainFacade.getBetsIdentifiers()
            .map { blockchainFacade.getBet(it) }
            .map { blockchainFacade.getBetPlayerInfo(it) }
            .filter { it.isParticipating && it.bet.isResolved }
        emit(list)
    }
}