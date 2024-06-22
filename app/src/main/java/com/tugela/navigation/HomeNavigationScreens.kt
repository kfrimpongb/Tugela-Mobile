package com.tugela.navigation

import androidx.navigation.NavController
import com.tugela.util.Constants

class HomeNavigationScreens (navController: NavController){
    val jobDetails:() -> Unit = {
        navController.navigate(Constants.JOBS_DETAILS)
    }
    val allSetScreen:() -> Unit = {
        navController.navigate(Constants.ALL_SET)
    }

    val profileScreens:() -> Unit = {
        navController.navigate(Constants.PROFILE_MAIN_SETUP)
    }
}
