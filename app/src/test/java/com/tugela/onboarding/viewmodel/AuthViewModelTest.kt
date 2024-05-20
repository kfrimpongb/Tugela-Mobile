package com.tugela.onboarding.viewmodel

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.tugela.data.models.requests.SignInModel
import com.tugela.domain.repository.auth.FakeAuthenticationRepository
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.use_cases.authentication.SignInRequestUseCase
import com.tugela.use_cases.authentication.SignUpRequestUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AuthViewModelTest {


    private val testDispatcher = StandardTestDispatcher()
    /*The test dispatchers, like StandardTestDispatcher, are used to simulate the behavior of the
     Dispatchers.Main in a controlled test environment.
    */

    private lateinit var authViewModel: AuthViewModel
    private lateinit var fakeAuthenticationRepository: FakeAuthenticationRepository

    @Before
    fun setUp(){
        fakeAuthenticationRepository = FakeAuthenticationRepository()
        authViewModel = AuthViewModel(
            signInRequestUseCase = SignInRequestUseCase(fakeAuthenticationRepository),
            signUpRequestUseCase = SignUpRequestUseCase(fakeAuthenticationRepository)
        )
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `signIn success`() = runTest {
        val signInModel = SignInModel(password  = "1234", email = "kenannan005@gmail.com")

        authViewModel.uiState.test {
            authViewModel.onEvent(AuthEvent.signInEvent(signInModel))

            // Advance the virtual clock until all tasks are completed
            advanceUntilIdle()

            assertThat(awaitItem()).isEqualTo(AuthUiState.loadingState)
            assertThat(awaitItem()).isEqualTo(AuthUiState.successState)
        }
    }


    @Test
    fun `signIn failure`() = runTest {
        val signInModel = SignInModel(password  = "65456", email = "kenannan005@gmail.com")

        authViewModel.uiState.test {
            authViewModel.onEvent(AuthEvent.signInEvent(signInModel))
            advanceUntilIdle()

            assertThat(awaitItem()).isEqualTo(AuthUiState.loadingState)
            assertThat(awaitItem()).isEqualTo(AuthUiState.failedState)
        }
    }


}