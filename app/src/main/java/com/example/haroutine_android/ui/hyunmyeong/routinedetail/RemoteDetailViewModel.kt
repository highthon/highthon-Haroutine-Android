package com.example.haroutine_android.ui.hyunmyeong.routinedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import com.example.haroutine_android.usecase.hyunmyeong.FetchRoutineDetailUseCase
import com.example.haroutine_android.util.MutableEventFlow
import com.example.haroutine_android.util.asEventFlow
import kotlinx.coroutines.launch

class RemoteDetailViewModel(): ViewModel() {

    val fetchRoutineDetailUseCase = FetchRoutineDetailUseCase()

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun fetchRoutineDetail(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                fetchRoutineDetailUseCase.execute(id)
            }.onSuccess {
                Event.FetchDetailSuccess(it)
            }.onFailure {
                Event.ErrorMessage("예상치 못한 오류가 발생하였습니다.")
            }
        }
    }

    sealed class Event {
        data class ErrorMessage(val message: String): Event()
        data class FetchDetailSuccess(val routineDetailResponse: RoutineDetailResponse): Event()
    }
}