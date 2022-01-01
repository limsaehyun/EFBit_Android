package com.saehyun.data.local.dao

import androidx.room.*
import com.saehyun.data.local.entitiy.ExchangeRoomEntity

@Dao
interface ExchangeDao {

    @Query("SELECT * FROM ExchangeRoomEntity")
    suspend fun getExchange(): ExchangeRoomEntity

    @Query("DELETE FROM ExchangeRoomEntity")
    suspend fun deleteExchange()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchange(exchangeRoomEntity: ExchangeRoomEntity)

    @Transaction
    suspend fun updateExchange(repo: ExchangeRoomEntity) {
        deleteExchange()
        insertExchange(repo)
    }



}