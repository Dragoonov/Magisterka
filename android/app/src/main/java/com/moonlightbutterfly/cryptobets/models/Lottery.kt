package com.moonlightbutterfly.cryptobets.models

data class Lottery(
    val title: String,
    val options: List<Option>,
    val minimumEntrance: Double,
    val identifier: String,
    val isResolved: Boolean
)