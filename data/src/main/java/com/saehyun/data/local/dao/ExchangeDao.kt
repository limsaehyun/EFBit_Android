package com.saehyun.data.local.dao

import androidx.room.*
import com.saehyun.data.local.entitiy.ExchangeRoomEntity

@Dao
interface ExchangeDao {

    @Query("SELECT * FROM exchange_room")
    suspend fun getExchange(): List<ExchangeRoomEntity>

    @Query("DELETE FROM exchange_room")
    suspend fun deleteExchange()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchange(exchangeRoomEntity: List<ExchangeRoomEntity>)

    @Transaction
    suspend fun updateExchange(repo: List<ExchangeRoomEntity>) {
        deleteExchange()
        insertExchange(repo)
    }



}