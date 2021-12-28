package com.saehyun.domain.handler

import com.saehyun.domain.base.ErrorHandlerEntity

interface ExchangeErrorHandler {
    fun getExchangeErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}