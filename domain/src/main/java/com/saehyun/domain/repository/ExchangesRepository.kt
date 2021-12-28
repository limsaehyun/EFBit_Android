package com.saehyun.domain.repository

import com.saehyun.domain.entity.exchange.ExchangeEntity
import kotlinx.coroutines.flow.Flow

interface ExchangesRepository {

    suspend fun getExchange(): Flow<ExchangeEntity>
}