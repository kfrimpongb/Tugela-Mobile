package com.tugela.onboarding.viewmodel

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugela.data.local.DataStoreManager
import com.tugela.data.local.PreferencesKeys
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.use_cases.UseCases
import com.tugela.util.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val useCases: UseCases,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _uiState = MutableSharedFlow<AuthUiState>()
    val uiState = _uiState.asSharedFlow()

    val customerType: StateFlow<String> by lazy {
        getDataStorePrefValue(PreferencesKeys.USER_TYPE)
    }

    val email: StateFlow<String> by lazy {
        getDataStorePrefValue(PreferencesKeys.EMAIL)
    }

    private fun <T> getDataStorePrefValue(key: Preferences.Key<T>): StateFlow<String> {
        val dataStoreValueFlow = MutableStateFlow<String>("")

        viewModelScope.launch {
            val value = dataStoreManager.getPreference(key)
                .firstOrNull()
                ?.toString() ?: ""
            dataStoreValueFlow.value = value
        }

        return dataStoreValueFlow
    }

    fun onEvent(event: AuthEvent) {
        when(event) {
            is AuthEvent.SignInEvent -> {
                viewModelScope.launch {
                    useCases.signInRequestUseCase.invoke(event.signInModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {
                                val signInResponse = dataState.data
                                if (signInResponse != null) {
                                    viewModelScope.launch(Dispatchers.IO) {
                                        dataStoreManager.savePreference(PreferencesKeys.ACCESSTOKEN_KEY, signInResponse.accessToken)
                                        dataStoreManager.savePreference(PreferencesKeys.USER_ID, signInResponse.clientId)
                                    }
                                    _uiState.emit(AuthUiState.successState(signInResponse.isProfileComplete, signInResponse.userType))

                                }
                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }

            is AuthEvent.SignUpEvent -> {
                viewModelScope.launch {
                    useCases.signUpRequestUseCase.invoke(event.signUpModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {
                                val signUpResponse = dataState.data
                                if (signUpResponse != null) {
                                    viewModelScope.launch(Dispatchers.IO) {
                                        dataStoreManager.savePreference(PreferencesKeys.ACCESSTOKEN_KEY, signUpResponse.accessToken)
                                        dataStoreManager.savePreference(PreferencesKeys.USER_ID, signUpResponse.clientId)
                                    }
                                    _uiState.emit(AuthUiState.successState(false, signUpResponse.userType))

                                }
                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }
            is AuthEvent.UpdateClient -> {
                viewModelScope.launch {
                    useCases.updateClientRequestUseCase.invoke(event.updateClientModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {

                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }
            is AuthEvent.UpdateFreelancer -> {
                viewModelScope.launch {
                    useCases.updateFreelancerRequestUseCase.invoke(event.updateFreelancerModel).onEach{ dataState->
                        when(dataState) {
                            is DataState.Loading -> {
                                _uiState.emit(AuthUiState.loadingState)
                            }
                            is DataState.Success -> {

                            }
                            is DataState.Error -> {
                                _uiState.emit(AuthUiState.failedState)
                            }
                        }
                    }.launchIn(viewModelScope)
                }
            }

            else -> {}
        }
        }


    fun saveDataStoreValue(preferenceKey: Preferences.Key<String>, value: String) {
        viewModelScope.launch {
            dataStoreManager.savePreference(preferenceKey, value)
        }
    }

    fun saveDataStoreBooleanValue(preferenceKey: Preferences.Key<Boolean>, value: Boolean) {
        viewModelScope.launch {
            dataStoreManager.savePreference(preferenceKey, value)
        }
    }

}