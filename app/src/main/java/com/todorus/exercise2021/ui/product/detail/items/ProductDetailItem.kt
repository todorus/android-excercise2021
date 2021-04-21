package com.todorus.exercise2021.ui.product.detail.items

import com.todorus.domain.Product

data class ProductDetailItem(
    val type: Type,
    val product: Product
) {
    enum class Type {
        HEADER,
        PRODUCT
    }
}