package com.saehyun.data.repository

import com.saehyun.data.local.datasource.LocalExchangeDataSource
import com.saehyun.data.local.entitiy.toRoomEntity
import com.saehyun.data.remote.datasource.exchange.RemoteExchangeDataSource
import com.saehyun.data.remote.model.toEntity
import com.saehyun.data.util.OfflineCacheUtil
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val remoteExchangeDataSource: RemoteExchangeDataSource,
    private val localExchangeDataSource: LocalExchangeDataSource
) : ExchangesRepository {

    override suspend fun getExchange(): Flow<ExchangeEntity> =
        OfflineCacheUtil<ExchangeEntity>()
            .remoteData { remoteExchangeDataSource.getExchange().toEntity() }
            .localData { localExchangeDataSource.getExchange() }
            .doOnNeedRefresh { localExchangeDataSource.updateExchange(it.toRoomEntity()) }
            .createFlow()
}