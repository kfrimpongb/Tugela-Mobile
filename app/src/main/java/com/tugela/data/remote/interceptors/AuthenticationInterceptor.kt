package com.tugela.data.remote.interceptors

import com.tugela.data.local.DataStoreManager
import com.tugela.data.local.PreferencesKeys
import com.tugela.util.Constants.ACCESSTOKEN
import com.tugela.util.SharedPref
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named


class AuthenticationInterceptor @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authKey: String? = runBlocking {
                dataStoreManager.getPreference(PreferencesKeys.ACCESSTOKEN_KEY).firstOrNull()
        }

        var request = chain.request()

        if (authKey.isNullOrEmpty()) {
            request = request.newBuilder()
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .addHeader("Accept", "*/*")
                .build()
        } else {
            Timber.tag("authKey").d("Bearer $authKey")
            request = request.newBuilder()
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .addHeader("Accept", "*/*")
                .build()

            if (request.headers["Authorization"].isNullOrEmpty()) {
                request = request.newBuilder()
                    .addHeader("Authorization", "Bearer $authKey")
                    .build()
            }
        }

        Timber.tag("requestUrl").d("${request.url}")
        Timber.tag("requestUrl").d(request.url.toUrl().path)
        Timber.tag("requestUrl").d(request.headers["Authorization"])
        Timber.tag("requestHeaders").d("${request.headers}")
        return chain.proceed(request)
    }

    companion object {
        private const val CONTENT_TYPE_JSON = "application/json"
    }
}