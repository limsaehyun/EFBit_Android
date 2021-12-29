package com.saehyun.data.remote.datasource.exchange

import com.saehyun.data.remote.network.ExchangeAPI
import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.domain.handler.ExchangeErrorHandler
import javax.inject.Inject

class RemoteExchangeDataSourceImpl @Inject constructor(
    private val exchangeAPI: ExchangeAPI,
    private val errorHandler: ExchangeErrorHandler
) : RemoteExchangeDataSource {

    override suspend fun getExchange(): ExchangeResponse =
        try {
            exchangeAPI.getExchange()
        } catch (e: Throwable) {
            throw errorHandler.getExchangeErrorHandler(e)
        }

}