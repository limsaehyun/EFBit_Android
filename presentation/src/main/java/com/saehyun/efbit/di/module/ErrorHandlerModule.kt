package com.saehyun.efbit.di.module

import com.saehyun.data.handler.ExchangeErrorHandlerImpl
import com.saehyun.domain.handler.ExchangeErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorHandlerModule {

    @Singleton
    @Provides
    fun errorHandler() : ExchangeErrorHandler = ExchangeErrorHandlerImpl()
}