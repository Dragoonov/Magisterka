package com.moonlightbutterfly.cryptobets.repository

import com.moonlightbutterfly.cryptobets.models.Lottery
import com.moonlightbutterfly.cryptobets.models.LotteryPlayerInfo

class BlockchainLotteryRepository: LotteryRepository {

    override fun getAllLotteries(): List<Lottery> {
        TODO("Not yet implemented")
    }

    override fun getLottery(lotteryIdentifier: String): Lottery {
        TODO("Not yet implemented")
    }

    override fun getLotteryPlayerInfo(
        playerIdentifier: String,
        lotteryIdentifier: String
    ): LotteryPlayerInfo {
        TODO("Not yet implemented")
    }

    override fun betLottery(playerIdentifier: String, lotteryIdentifier: String, bet: Double) {
        TODO("Not yet implemented")
    }

}
