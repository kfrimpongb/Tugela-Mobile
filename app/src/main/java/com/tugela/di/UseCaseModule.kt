package com.tugela.di


import com.tugela.domain.repository.AuthenticationRepository
import com.tugela.use_cases.UseCases
import com.tugela.use_cases.authentication.AuthenticationRequestUseCase
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
            authenticationRequestUseCase = AuthenticationRequestUseCase(authRepository),
        )
    }
}