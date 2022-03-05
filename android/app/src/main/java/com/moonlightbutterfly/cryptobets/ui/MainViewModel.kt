package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import kotlinx.coroutines.Dispatchers

class MainViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    private val _allBets = liveData(Dispatchers.IO) {
        val list = blockchainFacade.getBetsIdentifiers()
            .map { blockchainFacade.getBet(it) }
            .map { blockchainFacade.getBetPlayerInfo(it) }
        emit(list)
    }

    val allBets: LiveData<List<BetPlayerInfo>> = MediatorLiveData<List<BetPlayerInfo>>().apply {
        addSource(_allBets) { list ->
            postValue(
                list.filter { !it.bet.isResolved && !it.isParticipating }
            )
        }
    }
    val enteredBets: LiveData<List<BetPlayerInfo>> = MediatorLiveData<List<BetPlayerInfo>>().apply {
        addSource(_allBets) { list ->
            postValue(
                list.filter { !it.bet.isResolved && it.isParticipating }
            )
        }
    }

    val resolvedBets: LiveData<List<BetPlayerInfo>> = MediatorLiveData<List<BetPlayerInfo>>().apply {
        addSource(_allBets) { list ->
            postValue(
                list.filter { it.bet.isResolved && it.isParticipating }
            )
        }
    }
}