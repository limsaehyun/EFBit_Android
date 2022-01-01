package com.saehyun.data.local.datasource

import com.saehyun.data.local.entitiy.ExchangeRoomEntity

interface LocalExchangeDataSource {

    suspend fun getExchange(): ExchangeRoomEntity

    suspend fun insertExchange(exchangeRoomEntity: ExchangeRoomEntity)

    suspend fun updateExchange(exchangeRoomEntity: ExchangeRoomEntity)
}