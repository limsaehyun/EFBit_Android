package com.saehyun.data.remote.datasource

import com.saehyun.data.remote.ExchangeAPI
import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.domain.handler.ExchangeErrorHandler
import java.lang.Exception
import java.net.UnknownHostException
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