package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class ProductDeliveryCity(
    @Json(name = "deliveryCityImage")
    val deliveryCityImage: String,
    @Json(name = "isSendToSingleCity")
    val isSendToSingleCity: Boolean
)
