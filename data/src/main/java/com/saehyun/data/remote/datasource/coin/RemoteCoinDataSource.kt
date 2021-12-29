package com.saehyun.data.remote.datasource.coin

import com.saehyun.data.remote.model.CoinResponse
import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.domain.entity.exchange.ExchangeEntity

interface RemoteCoinDataSource {
    suspend fun getCoin() : CoinResponse
}