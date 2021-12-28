package com.saehyun.data.remote.model

data class Exchange(
    val exchange_id: String,
    val name: String,
    val volume_24h: Double,
    val website: String
)