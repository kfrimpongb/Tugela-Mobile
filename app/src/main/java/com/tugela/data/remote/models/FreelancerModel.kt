package com.tugela.data.remote.models

import com.google.gson.annotations.SerializedName

data class FreelancerModel(
    @SerializedName("entity_id")
    val freelancerId: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("middle_name")
    val middleName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("skills")
    val skills: String,
    @SerializedName("password")
    val experience: String,
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("base_currency")
    val currency: String?
)