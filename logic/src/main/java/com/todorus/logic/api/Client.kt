package com.todorus.logic.api

import com.todorus.logic.gson
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofitInstance(baseUrl: String, apiKey: String): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getHttpClientBuilder(apiKey).build())
        .addConverterFactory(jsonConverter)
        .build()

private val jsonConverter = GsonConverterFactory.create(gson)

fun getHttpClientBuilder(apiKey: String): OkHttpClient.Builder =
    OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
                .acceptOnlyJson()
                .addQueryParam("apikey", apiKey)
            chain.proceed(request)
        }

fun Request.acceptOnlyJson(): Request = this.newBuilder()
    .addHeader("Accept", "application/json")
    .build()

fun Request.addQueryParam(key: String, value: String): Request {
    val url: HttpUrl = this.url()
        .newBuilder()
        .addQueryParameter(key, value)
        .build()
    return this.newBuilder()
        .url(url)
        .build()
}