package com.moonlightbutterfly.cryptobets.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

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
