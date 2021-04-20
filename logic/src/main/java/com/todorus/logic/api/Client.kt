package com.todorus.logic.api

import com.todorus.logic.gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    .addInterceptor(
        object: Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()
                    .newBuilder()
                    .addHeader("Accept", "application/json")
                    .build()
                return chain.proceed(request)
            }
        }
    )

private val jsonConverter = GsonConverterFactory.create(gson)

val retrofitInstance = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build()