package com.moonlightbutterfly.cryptobets.models

data class LotteryPlayerInfo(
    val lottery: Lottery,
    val playerAddress: String,
    val isParticipating: Boolean,
    val contribution: Double,
    val reward: Double,
    val didPlayerWin: Boolean,
    val pickedOption: String
)
