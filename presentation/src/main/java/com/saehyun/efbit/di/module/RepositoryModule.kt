package com.saehyun.efbit.di.module

import com.saehyun.data.repository.CoinRepositoryImpl
import com.saehyun.data.repository.ExchangeRepositoryImpl
import com.saehyun.domain.repository.CoinRepository
import com.saehyun.domain.repository.ExchangesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {

    @Binds
    abstract fun bindExchangeRepositoryImpl(
        exchangeRepositoryImpl: ExchangeRepositoryImpl
    ): ExchangesRepository

    @Binds
    abstract fun bindCoinRepositoryImpl(
        coinRepositoryImpl: CoinRepositoryImpl
    ): CoinRepository
}