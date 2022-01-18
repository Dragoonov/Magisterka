package com.moonlightbutterfly.cryptobets.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import com.moonlightbutterfly.cryptobets.models.Option

class BlockchainBetsRepository(private val contractsSource: FirebaseFirestore) : BetsRepository {

    private val bets = MutableLiveData<List<Bet>>()

    override fun getAllBets(): LiveData<List<Bet>> {
        val list = mutableListOf<Bet>()
        contractsSource
            .collection("contracts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    list.add(getBet(document.id))
                }
                bets.postValue(list)
            }
        return bets
    }

    override fun getBet(betIdentifier: String): Bet {
        return Bet(
            title = betIdentifier,
            options = listOf(
                Option(1, "Opcja 1"),
                Option(2, "Opcja 2"),
                Option(3, "Opcja 3")
            ),
            minimumEntrance = 0.5,
            identifier = betIdentifier,
            isResolved = true
        )
    }

    override fun getBetPlayerInfo(
        playerIdentifier: String,
        betIdentifier: String
    ): BetPlayerInfo {
        return BetPlayerInfo(
            getBet(betIdentifier),
            isParticipating = true,
            contribution = 0.5,
            reward = 0.7,
            didPlayerWin = true,
            pickedOption = getBet(betIdentifier).options[0]
        )
    }

    override fun bet(playerIdentifier: String, betIdentifier: String, bet: Double, option: Option) {

    }

}
