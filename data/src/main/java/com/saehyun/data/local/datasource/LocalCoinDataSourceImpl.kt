package com.saehyun.data.local.datasource

import com.saehyun.data.local.dao.CoinDao
import com.saehyun.data.local.entitiy.CoinRoomEntity
import com.saehyun.data.local.entitiy.toMarket
import com.saehyun.domain.entity.coin.CoinEntity
import javax.inject.Inject

class LocalCoinDataSourceImpl @Inject constructor(
    private val coinDao: CoinDao
) : LocalCoinDataSource {
    override suspend fun getCoin(): CoinEntity =
        coinDao.getCoin().toMarket()

    override suspend fun insertCoin(coinRoomEntity: List<CoinRoomEntity>) =
        coinDao.insertCoin(coinRoomEntity)

    override suspend fun updateCoin(coinRoomEntity: List<CoinRoomEntity>) =
        coinDao.updateExchange(coinRoomEntity)
}