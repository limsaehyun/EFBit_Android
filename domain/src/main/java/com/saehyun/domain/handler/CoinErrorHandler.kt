package com.saehyun.domain.handler

import com.saehyun.domain.base.ErrorHandlerEntity

interface CoinErrorHandler {
    fun getCoinErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}