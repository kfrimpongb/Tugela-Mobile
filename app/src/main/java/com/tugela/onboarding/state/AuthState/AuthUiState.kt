package com.tugela.onboarding.state.AuthState

sealed class AuthUiState {
    data class successState(val isProfileComplete: Boolean, val userType: String) : AuthUiState()
    object failedState : AuthUiState()
    object loadingState: AuthUiState()
    object initState: AuthUiState()
}
