package com.movetrack.compose_network.data.repository


import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.models.responses.SignInResponse
import com.tugela.data.remote.AuthResponse
import com.tugela.data.remote.TugelaApi
import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel
import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.util.network.DataState
import extensions.makeNetworkRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuhenticationRepositoryImpl @Inject constructor(
    private val tugelaApi: TugelaApi,
) : AuthenticationRepository {
    override fun signIn(signInModel: SignInModel): Flow<DataState<SignInResponse>> {
        return makeNetworkRequest { tugelaApi.login(signInModel) }
    }
    override fun signUp(signUpModel: SignUpModel): Flow<DataState<AuthResponse>> {
        return makeNetworkRequest { tugelaApi.signUp(signUpModel) }
    }
    override fun updateClient(clientModel: ClientModel): Flow<DataState<Any>> {
        return makeNetworkRequest { tugelaApi.updateClient(clientModel) }
    }

    override fun updateFreelancer(freelancerModel: FreelancerModel): Flow<DataState<Any>> {
        return makeNetworkRequest { tugelaApi.updateFreelancer(freelancerModel) }
    }

}