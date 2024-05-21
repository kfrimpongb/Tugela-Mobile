package com.tugela.navigation

import androidx.navigation.NavController
import com.tugela.util.Constants

class NavigationScreens (navController: NavController){
    val signIn:() -> Unit = {
        navController.navigate(Constants.SIGN_IN_SCREEN)
    }

    val signUp:() -> Unit = {
        navController.navigate(Constants.SIGN_UP)
    }

    val forgetPin:() -> Unit = {
        navController.navigate(Constants.FORGET_PIN)
    }

    val profileSetup:() -> Unit = {
        navController.navigate(Constants.PROFILE_SETUP)
    }

    val customerType:() -> Unit = {
        navController.navigate(Constants.CUSTOMER_TYPE)
    }

    val freelanceSetup:() -> Unit = {
        navController.navigate(Constants.FREELANCE_SETUP)
    }

    val clientSetup:() -> Unit = {
        navController.navigate(Constants.CLIENT_SETUP)
    }


    val popToSignIn: ()-> Unit = {
        navController.popBackStack()
    }
}
