package com.saehyun.data.remote.model

import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market
import com.saehyun.domain.entity.exchange.ExchangeEntity

data class CoinResponse(
    val markets: List<Market>
)

fun CoinResponse.toMarket(): CoinEntity =
    CoinEntity(
        this.markets
    )