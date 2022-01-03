package com.saehyun.domain.repository

import com.saehyun.domain.entity.coin.CoinEntity
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoin(): Flow<CoinEntity>
}