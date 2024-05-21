package com.tugela.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tugela.navigation.routes.onBoardingComposable
import com.tugela.util.Constants

@Composable
fun SetupNavigation(
    navController: NavHostController
){
    val navigation = remember(navController) {
        NavigationScreens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination =  Constants.GET_STARTED_SCREEN
    ){
        onBoardingComposable(
            navigationController = navController,
            navigateToLoginScreen = navigation.signIn,
            navigateToSignUpScreen = navigation.signUp,
            navigateToForgetPinScreen = navigation.forgetPin,
            popToLoginScreen = navigation.popToSignIn,
            navigateToCustomerType = navigation.customerType,
            navigateToFreelancerSetup = navigation.freelanceSetup,
            navigateToClientSetup = {},
            navigateTopProfileSetup = {}
        )
    }

}