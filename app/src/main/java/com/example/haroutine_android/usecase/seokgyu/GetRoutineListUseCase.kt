package com.example.haroutine_android.usecase.seokgyu

import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.repository.SeokgyuRepository
import com.example.haroutine_android.usecase.UseCase

class GetRoutineListUseCase : UseCase<Unit, List<GetRoutineResponse>>() {
    val seokgyuRepository = SeokgyuRepository()
    override suspend fun execute(data: Unit): List<GetRoutineResponse> =
        seokgyuRepository.getRoutineList()
}
