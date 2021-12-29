package com.saehyun.data.handler

import com.saehyun.domain.base.ErrorHandlerEntity
import com.saehyun.domain.handler.CoinErrorHandler
import com.saehyun.domain.handler.ExchangeErrorHandler
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CoinErrorHandlerImpl: CoinErrorHandler {

    override fun getCoinErrorHandler(throwable: Throwable): ErrorHandlerEntity
    = when (throwable) {
        is HttpException -> when(throwable.code()) {
            404 -> ErrorHandlerEntity(sendMessage = "존재하지 않는 회원정보입니다")
            403 -> ErrorHandlerEntity(sendMessage = "권한이 없습니다")
            500 -> ErrorHandlerEntity(sendMessage = "서버 에러가 발생했습니다")
            else -> ErrorHandlerEntity(sendMessage = "알 수 없는 오류가 발생했습니다")
        }
        is ConnectException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 되지 않았습니다")
        is SocketTimeoutException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 불안정합니다")
        is UnknownHostException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 되지 않았습니다")
        else -> {
            ErrorHandlerEntity("Unknown")
        }
    }


}