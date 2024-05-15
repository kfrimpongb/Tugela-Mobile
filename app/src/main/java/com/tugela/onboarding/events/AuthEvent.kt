package com.tugela.onboarding.events

import androidx.compose.ui.focus.FocusState
import com.tugela.data.models.requests.SignInModel

sealed class AuthEvent {
    data class signInEvent(val signInModel: SignInModel): AuthEvent()

}