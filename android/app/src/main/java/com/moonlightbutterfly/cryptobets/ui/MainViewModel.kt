package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.moonlightbutterfly.cryptobets.models.Credentials
import com.moonlightbutterfly.cryptobets.models.Lottery
import com.moonlightbutterfly.cryptobets.models.LotteryPlayerInfo
import com.moonlightbutterfly.cryptobets.repository.LotteryRepository

class MainViewModel(
    private val credentials: Credentials,
    private val lotteryRepository: LotteryRepository
    ): ViewModel() {

    private val _allBets: MutableLiveData<List<Lottery>> = MutableLiveData()
    private val _allPlayerInfoBets: MutableLiveData<List<LotteryPlayerInfo>> = _allBets.map { list ->
        list.map { lotteryRepository.getLotteryPlayerInfo(credentials.publicKey, it.identifier) }
    } as MutableLiveData<List<LotteryPlayerInfo>>


    val allBets: LiveData<List<Lottery>> = _allBets

    val notEnteredBets = _allPlayerInfoBets.map { list ->
        list.filter { it.isParticipating }.map { it.lottery }
    }

    val enteredBets = _allPlayerInfoBets.map { list ->
        list.filter { it.isParticipating }
    }

    val resolvedBets = _allPlayerInfoBets.map { list ->
        list.filter { it.isParticipating && it.lottery.isResolved }
    }

    fun betLottery(lottery: Lottery, amount: Double) {
        lotteryRepository.betLottery(credentials.publicKey, lottery.identifier, amount)
    }
}