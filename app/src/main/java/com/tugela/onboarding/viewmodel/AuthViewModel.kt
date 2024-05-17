package com.tugela.onboarding.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.use_cases.authentication.SignInRequestUseCase
import com.tugela.use_cases.authentication.SignUpRequestUseCase
import com.tugela.util.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val signInRequestUseCase: SignInRequestUseCase,
    private val signUpRequestUseCase: SignUpRequestUseCase
) : ViewModel() {

    private val _uiState = MutableSharedFlow<AuthUiState>()
    val uiState = _uiState.asSharedFlow()

    fun onEvent(event: AuthEvent) {
        when(event) {
            is AuthEvent.signInEvent -> {
                viewModelScope.launch {
                    signInRequestUseCase.invoke(event.signInModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {
                                _uiState.emit(AuthUiState.successState)
                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }

            is AuthEvent.signUpEvent -> {
                viewModelScope.launch {
                    signUpRequestUseCase.invoke(event.signUpModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {
                                _uiState.emit(AuthUiState.successState)
                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }
            }
        }
    }