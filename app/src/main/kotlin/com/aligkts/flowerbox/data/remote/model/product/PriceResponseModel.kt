package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class PriceResponseModel(
    @Json(name = "currency")
    val currency: String,
    @Json(name = "currencyCode")
    val currencyCode: String,
    @Json(name = "current")
    val current: Double,
    @Json(name = "dateBasedDiscountAmount")
    val dateBasedDiscountAmount: Double,
    @Json(name = "discountPercentage")
    val discountPercentage: Int?,
    @Json(name = "old")
    val old: Double,
    @Json(name = "oldTotal")
    val oldTotal: Double,
    @Json(name = "showCurrencyCode")
    val showCurrencyCode: Boolean,
    @Json(name = "showDecimalPart")
    val showDecimalPart: Boolean,
    @Json(name = "showDotDecimalPart")
    val showDotDecimalPart: Boolean,
    @Json(name = "showFirstPrice")
    val showFirstPrice: Boolean,
    @Json(name = "showRegisterCardButton")
    val showRegisterCardButton: Boolean,
    @Json(name = "subscriptionDiscountPercentage")
    val subscriptionDiscountPercentage: Int?,
    @Json(name = "subscriptionPrice")
    val subscriptionPrice: Double,
    @Json(name = "tax")
    val tax: Any?,
    @Json(name = "total")
    val total: Double
)
