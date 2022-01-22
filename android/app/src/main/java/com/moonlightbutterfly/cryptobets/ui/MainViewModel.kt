package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.Option
import com.moonlightbutterfly.cryptobets.repository.BlockchainBetsRepository

class MainViewModel(
    betsRepository: BlockchainBetsRepository,
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    private val _allBets: LiveData<List<Bet>> = betsRepository.getAllBetsIdentifiers().map { list ->
        list.map { blockchainFacade.getBet(it) }
    }

    val allBets: LiveData<List<Bet>> = _allBets

    val enteredBets = _allBets.map { list ->
        list
            .map { blockchainFacade.getBetPlayerInfo(it, it.identifier) }
            .filter {
                it.isParticipating && !it.bet.isResolved
            }
    }

    val resolvedBets = _allBets.map { list ->
        list
            .map { blockchainFacade.getBetPlayerInfo(it, it.identifier) }
            .filter {
                it.isParticipating && it.bet.isResolved
            }
    }

    fun bet(bet: Bet, amount: Double, option: Option) {
        blockchainFacade.bet(bet.identifier, option, amount)
    }

    fun onCredentialsApproved(publicKey: String, privateKey: String) {
        blockchainFacade.initialize(privateKey, publicKey, allBets.value!!.map { it.identifier })

    }

    fun getBet(contract: String) = allBets.value!!.first { it.identifier == contract }
}