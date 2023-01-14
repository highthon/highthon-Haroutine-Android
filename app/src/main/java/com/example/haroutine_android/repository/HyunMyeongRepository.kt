package com.example.haroutine_android.repository

import com.example.haroutine_android.api.hyunMyeongApi
import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse

class HyunMyeongRepository() {

    suspend fun fetchRoutineDetail(id: Int): RoutineDetailResponse =
        hyunMyeongApi.fetchRoutineDetail(id)

    suspend fun postSignUp(name: String): String {
        return hyunMyeongApi.postSignUp(name)
    }
}
