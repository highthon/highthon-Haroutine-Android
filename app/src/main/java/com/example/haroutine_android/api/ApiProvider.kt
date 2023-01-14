package com.example.haroutine_android.api

import com.example.haroutine_android.repository.HyunMyeongRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("172.20.64.107:8080")
    addConverterFactory(GsonConverterFactory.create())
}.build()

val hyunMyeongApi: HyunMyeongApi by lazy {
    retrofit.create(HyunMyeongApi::class.java)
}

val seokgyuApi: SeokgyuApi by lazy {
    retrofit.create(SeokgyuApi::class.java)
}