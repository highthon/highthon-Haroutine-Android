package com.example.haroutine_android.api

import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HyunMyeongApi {

    @GET("/v1/routines/{id}")
    suspend fun fetchRoutineDetail(
        @Path("id") id: Int
    ): RoutineDetailResponse

    @POST("/v1/accounts")
    suspend fun postSignUp(
        @Body name: String
    ): String
}