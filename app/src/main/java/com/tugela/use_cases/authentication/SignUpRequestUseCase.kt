package com.tugela.use_cases.authentication

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpRequestUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    operator fun invoke(signUpModel: SignUpModel): Flow<DataState<Any>> {
        return  authenticationRepository.signUp(signUpModel)
    }
}