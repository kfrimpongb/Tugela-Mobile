package com.tugela.util

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.google.gson.Gson

class SharedPref(context: Context) {
    private val mSharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun setPref(title: String, value: Boolean) {
        val editor = mSharedPreferences.edit()
        editor.putBoolean(title, value)
        editor.apply()
    }

    fun setPref(title: String, value: String) {
        val editor = mSharedPreferences.edit()
        editor.putString(title, value)
        editor.apply()
    }

    fun setPref(title: String, value: Int) {
        val editor = mSharedPreferences.edit()
        editor.putInt(title, value)
        editor.apply()
    }

    fun <T> setPref(title: String, value: T) {
        val jsonValue = Gson().toJson(value)
        val editor = mSharedPreferences.edit()
        editor.putString(title, jsonValue)
        editor.apply()
    }

    fun saveUri(title: String, value: Uri) {
        val editor = mSharedPreferences.edit()
        editor.putString(title, value.toString())
        editor.apply()
    }

    fun getPref(title: String, def: Boolean): Boolean {
        return mSharedPreferences.getBoolean(title, def)
    }

    fun getPref(title: String, def: String): String? {
        return mSharedPreferences.getString(title, def)
    }

    fun getPref(title: String, def: Int): Int {
        return mSharedPreferences.getInt(title, def)
    }

    fun getUri(title: String, def: String): Uri {
        return Uri.parse(mSharedPreferences.getString(title, def))
    }

    fun <T> getObject(title: String, tClass: Class<T>): T? {
        val value = mSharedPreferences.getString(title, null)
        return Gson().fromJson(value, tClass)
    }
}
