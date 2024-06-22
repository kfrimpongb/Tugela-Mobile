package com.tugela.data.remote

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.models.responses.ApiResponse
import com.tugela.data.models.responses.SignInResponse
import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface TugelaApi {

    @POST("login")
    suspend fun login(@Body signInModel: SignInModel): ApiResponse<SignInResponse>

    @POST("create_user")
    suspend fun signUp(@Body signUpModel: SignUpModel): ApiResponse<AuthResponse>

    @PATCH("update_client_profile")
    suspend fun updateClient(@Body clientModel: ClientModel): ApiResponse<Any>

    @PATCH("update_freelancer_profile")
    suspend fun updateFreelancer(@Body freelancerModel: FreelancerModel): ApiResponse<Any>


}