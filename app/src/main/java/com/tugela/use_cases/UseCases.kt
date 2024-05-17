package com.tugela.use_cases

import com.tugela.use_cases.authentication.SignInRequestUseCase
import com.tugela.use_cases.authentication.SignUpRequestUseCase

data class UseCases(
    val signInRequestUseCase: SignInRequestUseCase,
    val signUpRequestUseCase: SignUpRequestUseCase
)
