package com.moonlightbutterfly.cryptobets.models

data class BetPlayerInfo(
    val bet: Bet,
    val isParticipating: Boolean,
    val contribution: Double,
    val reward: Double,
    val didPlayerWin: Boolean,
    val pickedOption: String,
    val winOption: String
)
