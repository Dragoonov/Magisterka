package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightbutterfly.cryptobets.repository.LotteryRepository

class MainViewModelProvider(private val lotteryRepository: LotteryRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.let {
            if (it.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(lotteryRepository) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}