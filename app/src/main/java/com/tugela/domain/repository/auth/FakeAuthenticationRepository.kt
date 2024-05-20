package com.tugela.domain.repository.auth

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAuthenticationRepository: AuthenticationRepository {
    override fun signIn(signInModel: SignInModel): Flow<DataState<Any>>  = flow{
       emit(DataState.Loading)
        delay(1000)//Simulate network delay
        if (signInModel.email == "kenannan005@gmail.com" && signInModel.password == "1234"){
            emit(DataState.Success(Any()))
        } else {
            emit(DataState.Error(Exception("Invalid Credentials")))
        }
    }

    override fun signUp(signUpModel: SignUpModel): Flow<DataState<Any>>  = flow{
        emit(DataState.Loading)
        delay(1000) // Simulate network delay
        if (signUpModel.fullName.isNotEmpty() && signUpModel.email.isNotEmpty() && signUpModel.password.isNotEmpty()) {
            emit(DataState.Success(Any()))
        } else {
            emit(DataState.Error(Exception("Invalid data")))
        }
    }
}