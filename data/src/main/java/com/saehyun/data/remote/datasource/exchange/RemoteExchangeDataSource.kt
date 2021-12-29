package com.saehyun.data.remote.datasource.exchange

import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.domain.entity.exchange.ExchangeEntity

interface RemoteExchangeDataSource {
    suspend fun getExchange() : ExchangeResponse
}