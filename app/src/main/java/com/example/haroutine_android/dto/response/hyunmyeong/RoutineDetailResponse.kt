package com.example.haroutine_android.dto.response.hyunmyeong

import com.google.gson.annotations.SerializedName

data class RoutineDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("RoutineInfo") val routineInfo: String
)