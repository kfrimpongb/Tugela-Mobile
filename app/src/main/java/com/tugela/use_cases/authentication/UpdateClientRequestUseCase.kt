package com.tugela.use_cases.authentication

import com.tugela.data.remote.models.ClientModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateClientRequestUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    operator fun invoke(clientModel: ClientModel): Flow<DataState<Any>> {
        return authenticationRepository.updateClient(clientModel)
    }
}