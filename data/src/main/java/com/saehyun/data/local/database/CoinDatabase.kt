package com.saehyun.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.saehyun.data.local.dao.CoinDao
import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.entitiy.CoinRoomEntity
import com.saehyun.data.local.entitiy.ExchangeRoomEntity

@Database(
    entities = [CoinRoomEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CoinDatabase: RoomDatabase() {
    abstract fun coinDao(): CoinDao
}