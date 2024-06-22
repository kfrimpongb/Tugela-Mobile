package com.tugela.data.remote.models

import com.google.gson.annotations.SerializedName

data class ClientModel(
    @SerializedName("client_id")
    val clientId: String?,
    @SerializedName("entity_name")
    val entityName: String?,
    @SerializedName("entity_id")
    val entityId: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("middle_name")
    val middleName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("currency")
    val currency: String?
)