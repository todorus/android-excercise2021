package com.todorus.logic.api

import com.todorus.domain.Product

interface ProductService {
    data class Result(
        val products: List<Product>
    )
}