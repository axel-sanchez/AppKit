package com.example.unfollowersinstagram.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Axel Sanchez
 * utilizo el patron de diseño Builder
 */
class ApiClient {
    class Builder<T>(private var baseUrl: String = "",
            private var apiService: Class<T>? = null){

        fun setBaseUrl(baseUrl: String) = apply{ this.baseUrl = baseUrl }
        fun setApiService(apiService: Class<T>) = apply{ this.apiService = apiService }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        fun build(): T{
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(apiService!!)
        }
    }
}