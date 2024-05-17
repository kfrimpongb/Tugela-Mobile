package com.tugela.domain.repository

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow


interface AuthenticationRepository {
    fun signIn(signInModel: SignInModel): Flow<DataState<Any>>
    fun signUp(signUpModel: SignUpModel): Flow<DataState<Any>>
}