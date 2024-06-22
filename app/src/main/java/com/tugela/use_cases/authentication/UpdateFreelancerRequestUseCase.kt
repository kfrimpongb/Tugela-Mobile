package com.tugela.use_cases.authentication

import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateFreelancerRequestUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    operator fun invoke(freelancerModel: FreelancerModel): Flow<DataState<Any>> {
        return authenticationRepository.updateFreelancer(freelancerModel)
    }
}