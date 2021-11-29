package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.models.Lottery
import com.moonlightbutterfly.cryptobets.models.LotteryPlayerInfo

interface LotteryRepository {

    fun getAllLotteries(): List<Lottery>

    fun getLottery(lotteryIdentifier: String): Lottery

    fun getLotteryPlayerInfo(playerIdentifier: String, lotteryIdentifier: String): LotteryPlayerInfo

    fun betLottery(playerIdentifier: String, lotteryIdentifier: String, bet: Double)

}