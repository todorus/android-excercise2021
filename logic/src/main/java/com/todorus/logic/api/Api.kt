package com.todorus.logic.api

object Api {
    val productService: ProductService = retrofitInstance.create(ProductService::class.java)
}