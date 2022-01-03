package com.saehyun.data.local.datasource

import com.saehyun.data.local.entitiy.CoinRoomEntity
import com.saehyun.domain.entity.coin.CoinEntity

interface LocalCoinDataSource {
    suspend fun getCoin(): CoinEntity

    suspend fun insertCoin(coinRoomEntity: List<CoinRoomEntity>)

    suspend fun updateCoin(coinRoomEntity: List<CoinRoomEntity>)

}