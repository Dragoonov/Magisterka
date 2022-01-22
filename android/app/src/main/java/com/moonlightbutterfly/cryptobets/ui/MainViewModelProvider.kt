package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightbutterfly.cryptobets.repository.BlockchainBetsRepository
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade

class MainViewModelProvider(
    private val betsRepository: BlockchainBetsRepository,
    private val blockchainFacade: BlockchainFacade
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.let {
            if (it.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(
                    betsRepository,
                    blockchainFacade
                ) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}