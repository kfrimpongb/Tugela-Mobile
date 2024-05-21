package com.tugela.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tugela.onboarding.screens.ClientProfileSetupScreen
import com.tugela.onboarding.screens.CreateAccountScreen
import com.tugela.onboarding.screens.CustomerTypeScreen
import com.tugela.onboarding.screens.ForgetPasswordScreen
import com.tugela.onboarding.screens.FreelancerProfileSetupScreen
import com.tugela.onboarding.screens.GetStartedScreen
import com.tugela.onboarding.screens.ProfileUpdateScreen
import com.tugela.onboarding.screens.SignInScreen
import com.tugela.util.Constants

fun NavGraphBuilder.onBoardingComposable(
    navigationController: NavController,
    navigateToLoginScreen: () -> Unit,
    navigateToSignUpScreen:() -> Unit,
    navigateToForgetPinScreen:() -> Unit,
    popToLoginScreen: () -> Unit,
    navigateToCustomerType: () -> Unit,
    navigateToFreelancerSetup: () -> Unit,
    navigateToClientSetup: () -> Unit,
    navigateTopProfileSetup: () -> Unit,
)
{
    composable(
        route = Constants.GET_STARTED_SCREEN,
    ){
        GetStartedScreen(
            navigateToSignIn = navigateToLoginScreen
        )
    }

    composable(
        route = Constants.SIGN_IN_SCREEN,
    ){
        SignInScreen(
            navigateToSignIn = navigateToSignUpScreen,
            navigateToForgetScreen = navigateToForgetPinScreen
        )
    }

    composable(
        route = Constants.SIGN_UP,
    ){
        CreateAccountScreen(
            popToLoginScreen = popToLoginScreen,
            navigateToSelectCustomerType = navigateToCustomerType
        )
    }


    composable(
        route = Constants.FORGET_PIN,
    ){
        ForgetPasswordScreen(
            navigateToSignIn = popToLoginScreen
        )
    }

    composable(
        route = Constants.CUSTOMER_TYPE,
    ){
        CustomerTypeScreen(
            navigateToClientSetup =  navigateToClientSetup,
            navigateToFreelancerSetup = navigateToFreelancerSetup,
            popBackStack = {}
        )
    }

    composable(
        route = Constants.FREELANCE_SETUP,
    ){
        FreelancerProfileSetupScreen()
    }

    composable(
        route = Constants.CLIENT_SETUP,
    ){
        ClientProfileSetupScreen()
    }

    composable(
        route = Constants.PROFILE_SETUP,
    ){
        ProfileUpdateScreen()
    }
}