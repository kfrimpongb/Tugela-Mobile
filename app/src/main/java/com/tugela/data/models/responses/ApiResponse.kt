package com.tugela.data.models.responses


data class ApiResponse<T>(
    val status: String,
    val type: String,
    val message: String,
    val data: T,
    val error: Any,
)
