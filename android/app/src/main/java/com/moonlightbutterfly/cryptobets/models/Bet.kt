package com.moonlightbutterfly.cryptobets.models

data class Bet(
    val title: String,
    val options: List<String>,
    val minimumEntrance: Double,
    val isResolved: Boolean
)