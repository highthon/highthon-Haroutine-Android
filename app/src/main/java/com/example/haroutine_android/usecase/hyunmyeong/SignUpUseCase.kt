package com.example.haroutine_android.usecase.hyunmyeong

import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import com.example.haroutine_android.repository.HyunMyeongRepository
import com.example.haroutine_android.usecase.UseCase

class SignUpUseCase(): UseCase<String, String>() {
    val hyunMyeongRepository = HyunMyeongRepository()
    override suspend fun execute(data: String): String =
        hyunMyeongRepository.postSignUp(data)
}
