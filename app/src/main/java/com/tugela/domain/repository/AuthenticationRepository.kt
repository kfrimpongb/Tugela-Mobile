package com.tugela.domain.repository

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.models.responses.SignInResponse
import com.tugela.data.remote.AuthResponse
import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow


interface AuthenticationRepository {
    fun signIn(signInModel: SignInModel): Flow<DataState<SignInResponse>>
    fun signUp(signUpModel: SignUpModel): Flow<DataState<AuthResponse>>
    fun updateClient(clientModel: ClientModel): Flow<DataState<Any>>
    fun updateFreelancer(freelancerModel: FreelancerModel): Flow<DataState<Any>>
}