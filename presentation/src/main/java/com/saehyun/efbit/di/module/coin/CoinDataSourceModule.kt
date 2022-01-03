package com.saehyun.efbit.di.module.coin

import com.saehyun.data.local.dao.CoinDao
import com.saehyun.data.local.datasource.LocalCoinDataSource
import com.saehyun.data.local.datasource.LocalCoinDataSourceImpl
import com.saehyun.data.local.datasource.LocalExchangeDataSourceImpl
import com.saehyun.data.remote.datasource.coin.RemoteCoinDataSource
import com.saehyun.data.remote.datasource.coin.RemoteCoinDataSourceImpl
import com.saehyun.data.remote.network.CoinAPI
import com.saehyun.domain.handler.CoinErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinDataSourceModule {
    @Singleton
    @Provides
    fun provideCoinRemoteDataSource(
        coinAPI: CoinAPI,
        errorHandler: CoinErrorHandler
    ): RemoteCoinDataSource = RemoteCoinDataSourceImpl(coinAPI, errorHandler)

    @Singleton
    @Provides
    fun provideLocalCoinDataSource(
        coinDao: CoinDao
    ) : LocalCoinDataSource = LocalCoinDataSourceImpl(coinDao)
}