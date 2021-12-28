package com.saehyun.domain.usecase

import com.saehyun.domain.base.UseCase
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExchangeUseCase @Inject constructor(
    private val exchangesRepository: ExchangesRepository
) : UseCase<Unit, Flow<ExchangeEntity>>() {

    override suspend fun execute(data: Unit): Flow<ExchangeEntity> =
        exchangesRepository.getExchange()
}