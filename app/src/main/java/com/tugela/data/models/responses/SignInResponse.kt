package com.tugela.data.models.responses

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("user_id")
    val clientId: String,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("is_profile_complete")
    val isProfileComplete: Boolean = false  ,
    @SerializedName("user_type")
    val userType: String
)
