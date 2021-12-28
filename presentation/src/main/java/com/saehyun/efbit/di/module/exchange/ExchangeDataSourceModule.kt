package com.saehyun.efbit.di.module.exchange

import com.saehyun.data.remote.ExchangeAPI
import com.saehyun.data.remote.datasource.RemoteExchangeDataSource
import com.saehyun.data.remote.datasource.RemoteExchangeDataSourceImpl
import com.saehyun.domain.handler.ExchangeErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExchangeDataSourceModule {
    @Singleton
    @Provides
    fun provideExchangeRemoteDataSource(
        exchangeAPI: ExchangeAPI,
        errorHandler: ExchangeErrorHandler
    ): RemoteExchangeDataSource = RemoteExchangeDataSourceImpl(exchangeAPI, errorHandler)
}