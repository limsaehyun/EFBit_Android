package com.saehyun.data.local.datasource

import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.entitiy.ExchangeRoomEntity
import com.saehyun.data.local.entitiy.toEntity
import com.saehyun.domain.entity.exchange.ExchangeEntity
import javax.inject.Inject

class LocalExchangeDataSourceImpl @Inject constructor(
    private val exchangeDao: ExchangeDao
) : LocalExchangeDataSource {

    override suspend fun getExchange() : ExchangeEntity =
        exchangeDao.getExchange().toEntity()

    override suspend fun insertExchange(exchangeRoomEntity: List<ExchangeRoomEntity>) =
        exchangeDao.insertExchange(exchangeRoomEntity)

    override suspend fun updateExchange(exchangeRoomEntity: List<ExchangeRoomEntity>) {
        exchangeDao.updateExchange(exchangeRoomEntity)
    }

}