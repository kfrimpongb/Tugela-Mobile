package com.tugela.data.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val ACCESSTOKEN_KEY = stringPreferencesKey("access_token")
    val USER_ID = stringPreferencesKey("user_id")
    val USER_TYPE = stringPreferencesKey("user_type")
    val EMAIL = stringPreferencesKey("email")
    val IS_SIGNED_IN = booleanPreferencesKey("is_signed_in")

}