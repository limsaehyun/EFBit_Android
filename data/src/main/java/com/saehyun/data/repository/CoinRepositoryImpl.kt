package com.saehyun.data.repository

import com.saehyun.data.remote.datasource.coin.RemoteCoinDataSource
import com.saehyun.data.remote.model.toEntity
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.repository.CoinRepository
import com.saehyun.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val remoteCoinDataSource: RemoteCoinDataSource
) : CoinRepository {

    override suspend fun getCoin(): Flow<CoinEntity> =
        flow {
            emit(remoteCoinDataSource.getCoin().toEntity())
        }
}