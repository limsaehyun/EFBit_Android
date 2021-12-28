package com.saehyun.data.remote.datasource

import com.saehyun.data.remote.model.ExchangeResponse

interface RemoteExchangeDataSource {
    suspend fun getExchange() : ExchangeResponse
}