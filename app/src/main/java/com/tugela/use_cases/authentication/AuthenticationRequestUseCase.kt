package com.tugela.use_cases.authentication

import com.tugela.data.models.requests.SignInModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthenticationRequestUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    operator fun invoke(signInModel: SignInModel): Flow<DataState<Any>> {
        return  authenticationRepository.signIn(signInModel)
    }
}