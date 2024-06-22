package com.tugela.data.remote


data class ApiResponse<T>(
    val status: String,
    val type: String,
    val message: String,
    val data: T,
    val error: Any,
)
