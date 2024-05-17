package com.tugela.data.remote

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.models.responses.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TugelaApi {

    @POST("v2/mobile/v1/login")
    suspend fun login(@Body signInModel: SignInModel): ApiResponse<Any>

    @POST("v2/mobile/v1/signup")
    suspend fun signUp(@Body signUpModel: SignUpModel): ApiResponse<Any>

}