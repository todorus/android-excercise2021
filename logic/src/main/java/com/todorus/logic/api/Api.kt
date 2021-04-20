package com.todorus.logic.api

class Api(baseUrl: String, apiKey: String) {
    val productService: ProductService = getRetrofitInstance(baseUrl, apiKey).create(ProductService::class.java)
}