package com.example.unfollowersinstagram.data.service

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Axel Sanchez
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("X-RapidAPI-Key", "3172e383acmsh9db1653ddfe4a7ep1092a9jsn7df3fa484d47") // Agrega encabezados personalizados aquí
            .addHeader("X-RapidAPI-Host", "instagram243.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}