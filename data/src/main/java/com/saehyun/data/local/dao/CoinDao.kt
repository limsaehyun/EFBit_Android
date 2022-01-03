package com.saehyun.data.local.dao

import androidx.room.*
import com.saehyun.data.local.entitiy.CoinRoomEntity

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin_room")
    suspend fun getCoin(): List<CoinRoomEntity>

    @Query("DELETE FROM coin_room")
    suspend fun deleteCoin()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coinRoomEntity: List<CoinRoomEntity>)

    @Transaction
    suspend fun updateExchange(repo: List<CoinRoomEntity>) {
        deleteCoin()
        insertCoin(repo)
    }



}