package com.saehyun.domain.entity.exchange

data class Exchange(
    val exchange_id: String,
    val name: String,
    val volume_24h: Double,
    val website: String
)