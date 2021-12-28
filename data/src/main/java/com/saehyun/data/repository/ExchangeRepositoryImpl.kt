package com.saehyun.data.repository

import com.saehyun.data.remote.datasource.RemoteExchangeDataSource
import com.saehyun.data.util.OfflineCacheUtil
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val remoteExchangeDataSource: RemoteExchangeDataSource
) : ExchangesRepository {

    override suspend fun getExchange(): Flow<ExchangeEntity> =
        flow {
            remoteExchangeDataSource.getExchange()
        }
}