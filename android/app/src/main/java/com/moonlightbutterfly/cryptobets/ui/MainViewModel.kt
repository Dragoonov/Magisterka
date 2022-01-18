package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.moonlightbutterfly.cryptobets.models.Credentials
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import com.moonlightbutterfly.cryptobets.models.Option
import com.moonlightbutterfly.cryptobets.repository.BetsRepository

class MainViewModel(
    private val betsRepository: BetsRepository
) : ViewModel() {

    private val _allBets: LiveData<List<Bet>> = betsRepository.getAllBets()

    val allBets: LiveData<List<Bet>> = _allBets

    val enteredBets = _allBets.map { list ->
        list
            .map { betsRepository.getBetPlayerInfo(Credentials.publicKey, it.identifier) }
            .filter {
                it.isParticipating && !it.bet.isResolved
            }
    }

    val resolvedBets = _allBets.map { list ->
        list
            .map { betsRepository.getBetPlayerInfo(Credentials.publicKey, it.identifier) }
            .filter {
                it.isParticipating && it.bet.isResolved
            }
    }

    fun bet(bet: Bet, amount: Double, option: Option) {
        betsRepository.bet(Credentials.publicKey, bet.identifier, amount, option)
    }

    fun onCredentialsApproved(publicKey: String, privateKey: String) {
        Credentials.privateKey = privateKey
        Credentials.publicKey = publicKey
    }

    fun getBet(contract: String) = betsRepository.getBet(contract)
}