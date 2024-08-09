package com.tugela.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tugela.data.local.DataStoreManager
import com.tugela.data.local.PreferencesKeys.IS_SIGNED_IN
import com.tugela.navigation.routes.onBoardingComposable
import com.tugela.onboarding.screens.SplashScreen
import com.tugela.onboarding.viewmodel.AuthViewModel
import com.tugela.util.Constants
import kotlinx.coroutines.flow.Flow

@Composable
fun SetupOnBoardingNavigation(
    navController: NavHostController,
    dataStoreManager: DataStoreManager // Injected instance of DataStoreManager
) {
    val navigation = remember(navController) {
        OnBoardingNavigationScreens(navController = navController)
    }

    val isSignedInFlow: Flow<Boolean?> = dataStoreManager.getPreference(IS_SIGNED_IN)

    // Collect the flow and handle state
    val isSignedInState by isSignedInFlow.collectAsState(initial = null)

        val startDestination = if (isSignedInState == true ) Constants.MAIN_SCREEN else Constants.GET_STARTED_SCREEN

        NavHost(
            navController = navController,
            startDestination =  startDestination
        ) {
            // Your composable destinations
            onBoardingComposable(
                navController,
                navigateToLoginScreen = navigation.signIn,
                navigateToSignUpScreen = navigation.signUp,
                navigateToForgetPinScreen = navigation.forgetPin,
                popToLoginScreen = navigation.popToSignIn,
                navigateToCustomerType = navigation.customerType,
                navigateToFreelancerSetup = navigation.freelanceSetup,
                navigateToClientSetup = navigation.clientSetup,
                navigateTopProfileSetup = navigation.clientSetup,
                navigateToMainScreen = navigation.mainScreen,
            )
        }

}

@Composable
fun LoadingScreen() {
    // Display a loading indicator or a placeholder
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}