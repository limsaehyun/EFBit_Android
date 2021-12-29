package com.saehyun.domain.entity.coin

import java.io.Serializable

data class Market(
    val base_asset: String,
    val change_24h: Double,
    val created_at: String,
    val exchange_id: String,
    val price: Double,
    val price_unconverted: Double,
    val quote_asset: String,
    val spread: Double,
    val status: String,
    val symbol: String,
    val updated_at: String,
    val volume_24h: Double
) : Serializable