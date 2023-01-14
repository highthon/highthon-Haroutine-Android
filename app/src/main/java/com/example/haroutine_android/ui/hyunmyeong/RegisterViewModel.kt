package com.example.haroutine_android.ui.hyunmyeong

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import com.example.haroutine_android.usecase.hyunmyeong.FetchRoutineDetailUseCase
import com.example.haroutine_android.usecase.hyunmyeong.SignUpUseCase
import com.example.haroutine_android.util.ACCESS_TOKEN
import com.example.haroutine_android.util.MutableEventFlow
import com.example.haroutine_android.util.asEventFlow
import kotlinx.coroutines.launch

class RegisterViewModel (): ViewModel() {

    private val signUpUseCase = SignUpUseCase()

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun signUp(name: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                ACCESS_TOKEN = signUpUseCase.execute(name)
            }.onSuccess {
                Event.Success
            }.onFailure {
                Event.ErrorMessage("예상치 못한 오류가 발생하였습니다.")
            }
        }
    }

    sealed class Event {
        data class ErrorMessage(val message: String): Event()
        object Success: Event()
    }
}