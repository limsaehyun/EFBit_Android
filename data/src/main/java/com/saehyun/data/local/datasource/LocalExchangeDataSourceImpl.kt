package com.saehyun.data.local.datasource

import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.entitiy.ExchangeRoomEntity
import javax.inject.Inject

class LocalExchangeDataSourceImpl @Inject constructor(
    private val exchangeDao: ExchangeDao
) : LocalExchangeDataSource {

    override suspend fun getExchange() : ExchangeRoomEntity =
        exchangeDao.getExchange()

    override suspend fun insertExchange(exchangeRoomEntity: ExchangeRoomEntity) =
        exchangeDao.insertExchange(exchangeRoomEntity)

    override suspend fun updateExchange(exchangeRoomEntity: ExchangeRoomEntity) {
        exchangeDao.updateExchange(exchangeRoomEntity)
    }

}