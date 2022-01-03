package com.saehyun.data.remote.datasource.coin

import com.saehyun.data.remote.model.CoinResponse

interface RemoteCoinDataSource {
    suspend fun getCoin() : CoinResponse
}