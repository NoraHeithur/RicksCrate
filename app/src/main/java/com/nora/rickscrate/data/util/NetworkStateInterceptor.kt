package com.nora.rickscrate.data.util

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.jvm.Throws

class NetworkStateInterceptor(context: Context) : Interceptor {

    private val _context = context

    @Throws(IOException::class)
    private fun isConnected(): Boolean {
        val connectivityManager =
            _context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) throw IOException("No Internet Connection!")
        return chain.proceed(chain.request().newBuilder().build())
    }
}