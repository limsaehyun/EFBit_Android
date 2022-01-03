package com.saehyun.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saehyun.data.local.dao.CoinDao
import com.saehyun.data.local.entitiy.CoinRoomEntity

@Database(
    entities = [CoinRoomEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CoinDatabase: RoomDatabase() {
    abstract fun coinDao(): CoinDao
}