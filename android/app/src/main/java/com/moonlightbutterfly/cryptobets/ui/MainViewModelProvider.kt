package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightbutterfly.cryptobets.repository.BetsRepository

class MainViewModelProvider(
    private val betsRepository: BetsRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.let {
            if (it.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(
                    betsRepository) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}