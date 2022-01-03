package com.saehyun.data.remote.model

import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market

data class CoinResponse(
    val markets: List<Market>
)

fun CoinResponse.toMarket(): CoinEntity =
    CoinEntity(
        this.markets
    )