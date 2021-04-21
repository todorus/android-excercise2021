package com.todorus.exercise2021.ui.product.detail.items

import com.todorus.domain.Product

open class ProductDetailItem(
    val type: Type
) {
    enum class Type {
        HEADER,
        PRODUCT,
        TITLE
    }
}

class ProductTitleItem(
    val stringResource: Int
): ProductDetailItem(Type.TITLE)

class ProductProductItem(
    val product: Product
): ProductDetailItem(Type.PRODUCT)

class ProductHeaderItem(
    val product: Product
): ProductDetailItem(Type.HEADER)