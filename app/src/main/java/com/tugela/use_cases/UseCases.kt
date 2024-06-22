package com.tugela.use_cases

import com.tugela.use_cases.authentication.SignInRequestUseCase
import com.tugela.use_cases.authentication.SignUpRequestUseCase
import com.tugela.use_cases.authentication.UpdateClientRequestUseCase
import com.tugela.use_cases.authentication.UpdateFreelancerRequestUseCase

data class UseCases(
    val signInRequestUseCase: SignInRequestUseCase,
    val signUpRequestUseCase: SignUpRequestUseCase,
    val updateClientRequestUseCase: UpdateClientRequestUseCase,
    val updateFreelancerRequestUseCase: UpdateFreelancerRequestUseCase,
)
