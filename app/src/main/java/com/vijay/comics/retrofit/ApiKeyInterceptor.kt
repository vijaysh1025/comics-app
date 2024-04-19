package com.vijay.comics.retrofit

import android.content.Context
import com.vijay.comics.R
import com.vijay.comics.retrofit.keys.ComicsApiKeys
import com.vijay.comics.utils.ResUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

internal class ApiKeyInterceptor(@ApplicationContext val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val keys = ResUtil.fromRawJson(ComicsApiKeys::class.java, context, R.raw.keys)
        val ts = System.currentTimeMillis().toString()
        val hash = "$ts${keys?.apiPrivateKey}${keys?.apiPublicKey}".md5()

        val originalRequest = chain.request()
        val newHttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", keys?.apiPublicKey)
            .addQueryParameter("hash", hash)
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newHttpUrl)
            .build()

        return chain.proceed(newRequest)
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(this.toByteArray())
        return digest.toHexString()
    }

}