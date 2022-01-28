package com.moonlightbutterfly.cryptobets

import androidx.lifecycle.ViewModel
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade

class LoginViewModel(
    private val blockchainFacade: BlockchainFacade
) : ViewModel() {

    fun onCredentialsApproved(privateKey: String) {
        blockchainFacade.initialize("5a81aeb2f7538e89833794b8e99874e816b5e4b6f2cfb1c4e71ab2ca09ae4c13")
    }
}