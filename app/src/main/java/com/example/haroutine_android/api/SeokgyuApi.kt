package com.example.haroutine_android.api

import com.example.haroutine_android.dto.response.seokgyu.CreateRoutineResponse
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.util.ACCESS_TOKEN
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface SeokgyuApi {
    @POST("v1/routines")
    suspend fun createRoutine(

    ): CreateRoutineResponse

    @GET("v1/routines")
    suspend fun getRoutineList(
        @Header("Authorization") token: String
    ): List<GetRoutineResponse>
}