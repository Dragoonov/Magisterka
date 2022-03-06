package com.moonlightbutterfly.cryptobets

import androidx.lifecycle.ViewModel
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade

class LoginViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    fun onCredentialsApproved(privateKey: String): Boolean {
        if (privateKey.trim().length != 64) {
            return false
        }
        blockchainFacade.initialize(privateKey)
        return true
    }
}