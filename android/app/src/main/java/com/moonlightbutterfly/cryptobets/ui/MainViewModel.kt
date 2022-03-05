package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    private val _isEmpty = MutableLiveData(true)
    val isEmpty: LiveData<Boolean> = _isEmpty

    private val _allBets = liveData(Dispatchers.IO) {
        val list = blockchainFacade.getBetsIdentifiers()
            .map { blockchainFacade.getBet(it) }
            .map { blockchainFacade.getBetPlayerInfo(it) }
        _isEmpty.postValue(false)
        emit(list)
    } as MutableLiveData

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

    val resolvedBets: LiveData<List<BetPlayerInfo>> =
        MediatorLiveData<List<BetPlayerInfo>>().apply {
            addSource(_allBets) { list ->
                postValue(
                    list.filter { it.bet.isResolved && it.isParticipating }
                )
            }
        }

    fun refresh() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _allBets.postValue(emptyList())
                _isEmpty.postValue(true)
                val list = blockchainFacade.getBetsIdentifiers()
                    .map { blockchainFacade.getBet(it) }
                    .map { blockchainFacade.getBetPlayerInfo(it) }
                _allBets.postValue(list)
                _isEmpty.postValue(false)
            }
        }
    }
}