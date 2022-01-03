package com.saehyun.efbit.di.module.exchange

import com.saehyun.data.local.dao.ExchangeDao
import com.saehyun.data.local.datasource.LocalExchangeDataSource
import com.saehyun.data.local.datasource.LocalExchangeDataSourceImpl
import com.saehyun.data.remote.network.ExchangeAPI
import com.saehyun.data.remote.datasource.exchange.RemoteExchangeDataSource
import com.saehyun.data.remote.datasource.exchange.RemoteExchangeDataSourceImpl
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

    @Singleton
    @Provides
    fun provideLocalExchangeDataSource(
        exchangeDao: ExchangeDao
    ) : LocalExchangeDataSource = LocalExchangeDataSourceImpl(exchangeDao)
}