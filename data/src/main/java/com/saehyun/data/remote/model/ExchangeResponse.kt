package com.saehyun.data.remote.model

import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity

data class ExchangeResponse(
    val exchanges: List<Exchange>
)

fun ExchangeResponse.toEntity(): ExchangeEntity =
    ExchangeEntity(
        this.exchanges
    )