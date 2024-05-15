package com.tugela.di

import com.movetrack.compose_network.data.repository.AuhenticationRepositoryImpl
import com.tugela.data.remote.TugelaApi
import com.tugela.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesAuthRepository(tugelaApi: TugelaApi): AuthenticationRepository {
        return AuhenticationRepositoryImpl(tugelaApi)
    }
}