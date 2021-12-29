package com.saehyun.efbit.di.module.coin

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
}