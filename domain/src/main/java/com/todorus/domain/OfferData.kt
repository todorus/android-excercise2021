package com.todorus.domain

data class OfferData(
    val bolCom:Int,
    val nonProfessionalSellers: Int,
    val professionalSellers: Int,
    val offers: List<Offer>
)