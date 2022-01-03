package com.saehyun.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.saehyun.data.local.database.Converters
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity
import java.io.Serializable

@Entity(tableName = "exchange_room")

data class ExchangeRoomEntity(
    val exchange_id: String,
    val name: String,
    val volume_24h: Double,
    val website: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun ExchangeRoomEntity.toExchange() =
    Exchange(
        this.exchange_id,
        this.name,
        this.volume_24h,
        this.website
    )

fun List<ExchangeRoomEntity>.toEntity(): ExchangeEntity =
    ExchangeEntity(
        this.map { it.toExchange() }
    )

fun Exchange.toRoomEntity() =
    ExchangeRoomEntity(
        exchange_id,
        name,
        volume_24h,
        website
    )


fun ExchangeEntity.toRoomEntity() =
    this.exchanges.map { it.toRoomEntity() }