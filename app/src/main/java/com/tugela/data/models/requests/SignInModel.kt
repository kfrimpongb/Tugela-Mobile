package com.tugela.data.models.requests

import com.google.gson.annotations.SerializedName

data class SignInModel(
    @SerializedName("email")
    val enail: String,
    @SerializedName("password")
    val password: String
)
