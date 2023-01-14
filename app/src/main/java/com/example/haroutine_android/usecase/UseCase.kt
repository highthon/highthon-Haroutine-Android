package com.example.haroutine_android.usecase

abstract class UseCase<I, O> {
    abstract suspend fun execute(data: I): O
}