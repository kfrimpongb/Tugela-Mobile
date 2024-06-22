package com.tugela.di

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.tugela.data.remote.TugelaApi
import com.tugela.data.remote.interceptors.AuthenticationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("tugela")
    fun provideRetrofit(@Named("tugelaClient")okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.8.100:8081/") // Use the IP address of your server
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideTugelaApi(@Named("tugela") retrofit: Retrofit): TugelaApi {
        return retrofit.create(TugelaApi::class.java)
    }


    @Singleton
    @Provides
    @Named("tugelaClient")
    fun provideOkHttp(
        authenticationInterceptor: AuthenticationInterceptor
    ) : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .addInterceptor (OkHttpProfilerInterceptor())
            .addInterceptor(authenticationInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}