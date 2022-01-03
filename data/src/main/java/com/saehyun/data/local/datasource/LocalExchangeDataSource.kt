package com.saehyun.data.local.datasource

import com.saehyun.data.local.entitiy.ExchangeRoomEntity
import com.saehyun.domain.entity.exchange.ExchangeEntity

interface LocalExchangeDataSource {
    suspend fun getExchange(): ExchangeEntity

    suspend fun insertExchange(exchangeRoomEntity: List<ExchangeRoomEntity>)

    suspend fun updateExchange(exchangeRoomEntity: List<ExchangeRoomEntity>)
}