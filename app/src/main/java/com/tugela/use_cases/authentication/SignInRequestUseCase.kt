package com.tugela.use_cases.authentication

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.responses.SignInResponse
import com.tugela.data.remote.AuthResponse
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInRequestUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    operator fun invoke(signInModel: SignInModel): Flow<DataState<SignInResponse>> {
        return  authenticationRepository.signIn(signInModel)
    }
}