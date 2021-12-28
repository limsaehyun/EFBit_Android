package com.saehyun.domain.base

abstract class UseCase<T, E> {
    abstract suspend fun execute(data: T): E
}