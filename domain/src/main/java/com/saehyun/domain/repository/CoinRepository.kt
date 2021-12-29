package com.saehyun.domain.repository

import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoin(): Flow<CoinEntity>
}