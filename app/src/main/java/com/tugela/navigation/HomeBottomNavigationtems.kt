package com.tugela.navigation

import com.tugela.R
import com.tugela.util.Constants

sealed class HomeBottomNavigationtems(var route: String, val icon: Int, var title: String) {
    object Jobs : HomeBottomNavigationtems(Constants.JOBS_SCREEN, R.drawable.ic_home, "")
    object History : HomeBottomNavigationtems(Constants.HISTORY_SCREEN, R.drawable.ic_package, "")
    object Profile : HomeBottomNavigationtems(Constants.PROFILE_SCREEN, R.drawable.ic_profile, "")
    object Settings : HomeBottomNavigationtems(Constants.SETTINGS_SCREEN, R.drawable.ic_settings, "")
    object Notification : HomeBottomNavigationtems(Constants.NOTIFICATION_SCREEN, R.drawable.ic_notification, "")
}