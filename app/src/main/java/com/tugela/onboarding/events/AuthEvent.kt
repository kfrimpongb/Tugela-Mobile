package com.tugela.onboarding.events

import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel
import com.tugela.data.remote.models.ClientModel
import com.tugela.data.remote.models.FreelancerModel

sealed class AuthEvent {
    data class SignInEvent(val signInModel: SignInModel): AuthEvent()
    data class SignUpEvent(val signUpModel: SignUpModel): AuthEvent()
    data class UpdateClient(val updateClientModel: ClientModel): AuthEvent()
    data class UpdateFreelancer(val updateFreelancerModel: FreelancerModel): AuthEvent()

}