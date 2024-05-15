package com.tugela.data.models.responses

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("email")
    val enail: String,
    @SerializedName("password")
    val password: String
)
