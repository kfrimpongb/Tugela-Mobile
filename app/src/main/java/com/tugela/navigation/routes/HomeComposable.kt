package com.tugela.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tugela.onboarding.screens.home.MainScreen
import com.tugela.util.Constants

fun NavGraphBuilder.homeComposable(
    navController: NavHostController,
    navigateToHomeScreen: () -> Unit,
    navigateToSecondScreen:() -> Unit,
    navigateToThirdScreen:() -> Unit
)
{
    composable(route = Constants.HONE_ACTIVITY) {
        MainScreen()
    }
}