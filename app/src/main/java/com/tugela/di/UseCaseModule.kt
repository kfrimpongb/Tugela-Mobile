package com.tugela.di


import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.use_cases.UseCases
import com.tugela.use_cases.authentication.SignInRequestUseCase
import com.tugela.use_cases.authentication.SignUpRequestUseCase
import com.tugela.use_cases.authentication.UpdateClientRequestUseCase
import com.tugela.use_cases.authentication.UpdateFreelancerRequestUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun providesUseCases(
        authRepository: AuthenticationRepository,
    ): UseCases {
        return UseCases(
            signInRequestUseCase = SignInRequestUseCase(authRepository),
            signUpRequestUseCase = SignUpRequestUseCase(authRepository),
            updateClientRequestUseCase = UpdateClientRequestUseCase(authRepository),
            updateFreelancerRequestUseCase = UpdateFreelancerRequestUseCase(authRepository)
        )
    }
}