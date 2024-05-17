package com.tugela.onboarding.events

import androidx.compose.ui.focus.FocusState
import com.tugela.data.models.requests.SignInModel
import com.tugela.data.models.requests.SignUpModel

sealed class AuthEvent {
    data class signInEvent(val signInModel: SignInModel): AuthEvent()
    data class signUpEvent(val signUpModel: SignUpModel): AuthEvent()

}