package com.tugela.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tugela.components.DrawerContent
import com.tugela.onboarding.screens.AllSetScreen
import com.tugela.onboarding.screens.JobDetailsScreen
import com.tugela.onboarding.screens.ProfileScreen
import com.tugela.onboarding.screens.home.MainHomeScreen
import com.tugela.util.Constants
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupHomeNavigations(navController: NavHostController) {

    val navigation = remember(navController) {
        HomeNavigationScreens(navController = navController)
    }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(navigation.profileScreens)
            }
        },
        content = {
            NavHost(navController, startDestination = HomeBottomNavigationtems.Jobs.route) {
                composable(HomeBottomNavigationtems.Jobs.route) {
                    MainHomeScreen(
                        navigateToJobDetailsScreen = navigation.jobDetails,
                        navigateToProfileScreen = navigation.profileScreens,
                        openDrawer = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }
                composable(Constants.JOBS_DETAILS) {
                    JobDetailsScreen(navigation.allSetScreen)
                }
                composable(Constants.ALL_SET) {
                    AllSetScreen()
                }
                composable(Constants.PROFILE_MAIN_SETUP) {
                    ProfileScreen()
                }
                composable(HomeBottomNavigationtems.History.route) {}
                composable(HomeBottomNavigationtems.Profile.route) {}
                composable(HomeBottomNavigationtems.Settings.route) {}
                composable(HomeBottomNavigationtems.Notification.route) {}
            }
        }
    )
}