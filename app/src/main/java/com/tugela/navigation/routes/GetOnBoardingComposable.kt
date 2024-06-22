package com.tugela.navigation.routes

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tugela.onboarding.screens.ClientProfileSetupScreen
import com.tugela.onboarding.screens.CreateAccountScreen
import com.tugela.onboarding.screens.CustomerTypeScreen
import com.tugela.onboarding.screens.ForgetPasswordScreen
import com.tugela.onboarding.screens.FreelancerProfileSetupScreen
import com.tugela.onboarding.screens.GetStartedScreen
import com.tugela.onboarding.screens.ProfileUpdateScreen
import com.tugela.onboarding.screens.SignInScreen
import com.tugela.onboarding.screens.home.MainScreen
import com.tugela.onboarding.viewmodel.AuthViewModel
import com.tugela.util.Constants

fun NavGraphBuilder.onBoardingComposable(
    navigationHostController: NavHostController,
    navigateToLoginScreen: () -> Unit,
    navigateToSignUpScreen:() -> Unit,

    navigateToForgetPinScreen:() -> Unit,
    popToLoginScreen: () -> Unit,
    navigateToCustomerType: () -> Unit,
    navigateToFreelancerSetup: () -> Unit,
    navigateToClientSetup: () -> Unit,
    navigateTopProfileSetup: () -> Unit,
    navigateToMainScreen: () -> Unit,
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
            navigateToSignUp = navigateToCustomerType,
            navigateToForgetScreen = navigateToForgetPinScreen,
            navigateToClientSetup = navigateToClientSetup,
            navigateToFreelancerSetup = navigateToFreelancerSetup,
            navigateToMainScreen = navigateToMainScreen
        )
    }

    composable(
        route = Constants.SIGN_UP,
        arguments = listOf(navArgument("customerType") { type = NavType.StringType })

    ){

        CreateAccountScreen(
            popToLoginScreen = popToLoginScreen,
                    navigateToClientSetup,
            navigateToFreelancerSetup
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
        route = Constants.CUSTOMER_TYPE_SCREEN,
    ){
        CustomerTypeScreen(
            navigateToClientSetup =  navigateToSignUpScreen,
            navigateToFreelancerSetup = navigateToSignUpScreen,
            popBackStack = {}
        )
    }

    composable(
        route = Constants.FREELANCE_SETUP,
    ){
        FreelancerProfileSetupScreen(navigateToMainScreen)
    }

    composable(
        route = Constants.CLIENT_SETUP,
    ){
        ClientProfileSetupScreen(navigateToMainScreen)
    }

    composable(
        route = Constants.PROFILE_SETUP,
    ){
        ProfileUpdateScreen()
    }

    composable(
        route = Constants.MAIN_SCREEN
    ){
        MainScreen()
    }
}