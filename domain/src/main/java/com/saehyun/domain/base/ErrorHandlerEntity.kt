package com.saehyun.domain.base

data class ErrorHandlerEntity (
    val sendMessage: String
): Throwable()