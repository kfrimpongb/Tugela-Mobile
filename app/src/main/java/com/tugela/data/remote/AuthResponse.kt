package com.tugela.data.remote

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("user_id")
    val clientId: String,
    @SerializedName("access-token")
    val accessToken: String,
    @SerializedName("user_type")
    val userType: String
)
