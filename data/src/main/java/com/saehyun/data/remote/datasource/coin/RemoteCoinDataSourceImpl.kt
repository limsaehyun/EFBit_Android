package com.saehyun.data.remote.datasource.coin

import com.saehyun.data.remote.datasource.exchange.RemoteExchangeDataSource
import com.saehyun.data.remote.model.CoinResponse
import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.data.remote.network.CoinAPI
import com.saehyun.domain.handler.CoinErrorHandler
import com.saehyun.domain.handler.ExchangeErrorHandler
import javax.inject.Inject

class RemoteCoinDataSourceImpl @Inject constructor(
    private val coinAPI: CoinAPI,
    private val errorHandler: CoinErrorHandler
) : RemoteCoinDataSource {

    override suspend fun getCoin(): CoinResponse =
        try {
            coinAPI.getCoin()
        } catch (e: Throwable) {
            throw errorHandler.getCoinErrorHandler(e)
        }

}