package com.example.haroutine_android.repository

import com.example.haroutine_android.api.seokgyuApi
import com.example.haroutine_android.dto.response.seokgyu.CreateRoutineResponse
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.util.ACCESS_TOKEN

class SeokgyuRepository {
    suspend fun createRoutine(): CreateRoutineResponse =
        seokgyuApi.createRoutine()

    suspend fun getRoutineList(): List<GetRoutineResponse> =
        seokgyuApi.getRoutineList(ACCESS_TOKEN)
}