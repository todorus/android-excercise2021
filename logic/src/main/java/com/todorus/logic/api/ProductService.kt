package com.todorus.logic.api

import com.todorus.domain.Product
import retrofit2.http.GET
import retrofit2.http.Path


interface ProductService {

    @GET("catalog/v4/products/{id}")
    suspend fun get(@Path("id") id: String): Result

    @GET("catalog/v4/recommendations/{id}")
    suspend fun getRecommendations(@Path("id") id: String): Result

    @GET("catalog/v4/relatedproducts/{id}")
    suspend fun getRelated(@Path("id") id: String): Result

    data class Result(
        val products: List<Product>
    )
}