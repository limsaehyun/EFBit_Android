package com.saehyun.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market

@Entity(tableName = "coin_room")

data class CoinRoomEntity(
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
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun CoinRoomEntity.toMarket() =
    Market(
        this.base_asset,
        this.change_24h,
        this.created_at,
        this.exchange_id,
        this.price,
        this.price_unconverted,
        this.quote_asset,
        this.spread,
        this.status,
        this.symbol,
        this.updated_at,
        this.volume_24h,
    )

fun List<CoinRoomEntity>.toMarket(): CoinEntity =
    CoinEntity(
        this.map { it.toMarket() }
    )

fun Market.toRoomEntity() =
    CoinRoomEntity(
        this.base_asset,
        this.change_24h,
        this.created_at,
        this.exchange_id,
        this.price,
        this.price_unconverted,
        this.quote_asset,
        this.spread,
        this.status,
        this.symbol,
        this.updated_at,
        this.volume_24h,
    )


fun CoinEntity.toRoomEntity() =
    this.markets.map { it.toRoomEntity() }