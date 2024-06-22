package com.tugela.data.models.requests

import com.google.gson.annotations.SerializedName

data class SignUpModel(
    @SerializedName("customer_type")
    val customerType: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
