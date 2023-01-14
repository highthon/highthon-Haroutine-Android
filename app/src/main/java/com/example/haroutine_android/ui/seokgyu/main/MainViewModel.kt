package com.example.haroutine_android.ui.seokgyu.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.usecase.seokgyu.GetRoutineListUseCase
import com.example.haroutine_android.util.MutableEventFlow
import com.example.haroutine_android.util.asEventFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val getRoutineListUseCase = GetRoutineListUseCase()

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getRoutineList() {
        viewModelScope.launch {
            kotlin.runCatching {
                getRoutineListUseCase.execute(Unit)
            }.onSuccess {
                Event.GetRoutineSuccess(it)
            }.onFailure {
                Event.ErrorMessage("예상치 못한 오류가 발생하였습니다.")
            }
        }
    }

    sealed class Event {
        data class ErrorMessage(val message: String): Event()
        data class GetRoutineSuccess(val getRoutineResponse: List<GetRoutineResponse>): Event()
    }
}