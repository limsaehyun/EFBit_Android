package com.saehyun.efbit.di.module

import android.content.Context
import androidx.room.Room
import com.saehyun.data.local.dao.CoinDao
import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.database.CoinDatabase
import com.saehyun.data.local.database.ExchangeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideExchangeDatabase(
        @ApplicationContext context: Context
    ): ExchangeDatabase = Room
        .databaseBuilder(
            context,
            ExchangeDatabase::class.java,
            "exchange"
        ).build()

    @Provides
    fun provideExchangeDao(
        exchangeDatabase: ExchangeDatabase
    ): ExchangeDao = exchangeDatabase.exchangeDao()

    @Provides
    fun provideCoinDatabase(
        @ApplicationContext context: Context
    ): CoinDatabase = Room
        .databaseBuilder(
            context,
            CoinDatabase::class.java,
            "coin"
        ).build()

    @Provides
    fun provideCoinDao(
        coinDatabase: CoinDatabase
    ): CoinDao = coinDatabase.coinDao()
}