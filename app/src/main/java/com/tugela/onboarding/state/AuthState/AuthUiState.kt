package com.tugela.onboarding.state.AuthState

sealed class AuthUiState {
    object successState : AuthUiState()
    object failedState : AuthUiState()
    object loadingState: AuthUiState()
    object initState: AuthUiState()
}
