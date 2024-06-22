package com.tugela.domain.repository.auth

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.models.responses.SignInResponse
import com.tugela.data.remote.AuthResponse
import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAuthenticationRepository: AuthenticationRepository {
    override fun signIn(signInModel: SignInModel): Flow<DataState<SignInResponse>>  = flow{
       emit(DataState.Loading)
        delay(1000)//Simulate network delay
        if (signInModel.email == "kenannan005@gmail.com" && signInModel.password == "1234"){
//            emit(DataState.Success(SignInResponse()))
        } else {
            emit(DataState.Error(Exception("Invalid Credentials")))
        }
    }

    override fun signUp(signUpModel: SignUpModel): Flow<DataState<AuthResponse>>  = flow{
        emit(DataState.Loading)
        delay(1000) // Simulate network delay
        if (signUpModel.email.isNotEmpty() && signUpModel.password.isNotEmpty()) {
//            emit(DataState.Success(SignUpResponse))
        } else {
            emit(DataState.Error(Exception("Invalid data")))
        }
    }

    override fun updateClient(clientModel: ClientModel) = flow{
        emit(DataState.Loading)
    }

    override fun updateFreelancer(freelancerModel: FreelancerModel)= flow{
        emit(DataState.Loading)
    }
}