package com.moonlightbutterfly.cryptobets.repository

import androidx.lifecycle.LiveData
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.BetPlayerInfo
import com.moonlightbutterfly.cryptobets.models.Option

interface BetsRepository {

    fun getAllBets(): LiveData<List<Bet>>

    fun getBet(betIdentifier: String): Bet

    fun getBetPlayerInfo(playerIdentifier: String, betIdentifier: String): BetPlayerInfo

    fun bet(playerIdentifier: String, betIdentifier: String, bet: Double, option: Option)

}