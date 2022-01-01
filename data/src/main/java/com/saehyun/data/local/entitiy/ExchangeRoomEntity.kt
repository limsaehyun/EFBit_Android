package com.saehyun.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saehyun.data.remote.model.ExchangeResponse
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity

@Entity
data class ExchangeRoomEntity(
    val exchange: List<Exchange>
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun ExchangeRoomEntity.toEntity(): ExchangeEntity =
    ExchangeEntity(
        this.exchange
    )