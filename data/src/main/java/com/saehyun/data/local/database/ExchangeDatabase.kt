package com.saehyun.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.entitiy.ExchangeRoomEntity

@Database(
    entities = [ExchangeRoomEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ExchangeDatabase: RoomDatabase() {
    abstract fun exchangeDao() : ExchangeDao
}