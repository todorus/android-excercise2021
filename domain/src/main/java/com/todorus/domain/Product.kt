package com.todorus.domain

data class Product (
    val id: String,
    val ean: String,
    val title: String,
    val rating: Int,
    val shortDescription: String,
    val longDescription: String,
    val attributeGroups: List<AttributeGroup>,
    val images: List<Attribute>,
    val offerData: OfferData
)