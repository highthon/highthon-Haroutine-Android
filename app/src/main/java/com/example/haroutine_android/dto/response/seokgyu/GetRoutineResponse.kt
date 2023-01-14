package com.example.haroutine_android.dto.response.seokgyu

import com.google.gson.annotations.SerializedName

data class GetRoutineResponse(
    val id: Int,
    val title: String,
    val content: String,
    val tags: List<String>,
    val writer: String,
    @SerializedName("start_time") val startTime: String,
    @SerializedName("last_time") val lastTime: String
)