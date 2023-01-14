package com.example.haroutine_android.usecase.hyunmyeong

import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import com.example.haroutine_android.repository.HyunMyeongRepository
import com.example.haroutine_android.usecase.UseCase

class FetchRoutineDetailUseCase(): UseCase<Int, RoutineDetailResponse>() {
    val hyunMyeongRepository = HyunMyeongRepository()
    override suspend fun execute(data: Int): RoutineDetailResponse =
        hyunMyeongRepository.fetchRoutineDetail(data)
}
