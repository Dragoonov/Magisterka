package com.moonlightbutterfly.cryptobets.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import com.moonlightbutterfly.cryptobets.models.Option

class BlockchainBetsRepository(private val contractsSource: FirebaseFirestore) {

    private val bets = MutableLiveData<List<String>>()

    fun getAllBetsIdentifiers(): LiveData<List<String>> {
        val list = mutableListOf<String>()
        contractsSource
            .collection("contracts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    list.add(document.id)
                }
                bets.postValue(list)
            }
        return bets
    }

}
