package com.saehyun.data.remote.network

import com.saehyun.data.remote.model.ExchangeResponse
import retrofit2.http.GET

interface ExchangeAPI {

    // Exchange 가져오기
    @GET("exchanges")
    suspend fun getExchange() : ExchangeResponse
}