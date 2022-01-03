package com.saehyun.domain.usecase

import com.saehyun.domain.base.UseCase
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) : UseCase<Unit, Flow<CoinEntity>>() {

    override suspend fun execute(data: Unit): Flow<CoinEntity> =
        coinRepository.getCoin()
}