package com.saehyun.data.remote.network

import com.saehyun.data.remote.model.CoinResponse
import retrofit2.http.GET

interface CoinAPI {

    // Coin 가져오기
    @GET("markets")
    suspend fun getCoin() : CoinResponse
}