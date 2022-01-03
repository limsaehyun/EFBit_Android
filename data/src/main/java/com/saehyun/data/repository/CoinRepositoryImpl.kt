package com.saehyun.data.repository

import com.saehyun.data.local.datasource.LocalCoinDataSource
import com.saehyun.data.local.entitiy.toRoomEntity
import com.saehyun.data.remote.datasource.coin.RemoteCoinDataSource
import com.saehyun.data.remote.model.toEntity
import com.saehyun.data.remote.model.toMarket
import com.saehyun.data.util.OfflineCacheUtil
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.repository.CoinRepository
import com.saehyun.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val remoteCoinDataSource: RemoteCoinDataSource,
    private val localCoinDataSource: LocalCoinDataSource
) : CoinRepository {
    override suspend fun getCoin(): Flow<CoinEntity> =
        OfflineCacheUtil<CoinEntity>()
            .remoteData { remoteCoinDataSource.getCoin().toMarket() }
            .localData { localCoinDataSource.getCoin() }
            .doOnNeedRefresh { localCoinDataSource.updateCoin(it.toRoomEntity()) }
            .createFlow()
}