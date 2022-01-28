package com.moonlightbutterfly.cryptobets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightbutterfly.cryptobets.LoginViewModel
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade

class ViewModelProvider(
    private val blockchainFacade: BlockchainFacade
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.let {
            when {
                it.isAssignableFrom(MainViewModel::class.java) -> {
                    MainViewModel(
                        blockchainFacade
                    ) as T
                }
                it.isAssignableFrom(LoginViewModel::class.java) -> {
                    LoginViewModel(
                        blockchainFacade
                    ) as T
                }
                else -> {
                    throw Exception("Not supported ViewModel")
                }
            }
        }
    }
}