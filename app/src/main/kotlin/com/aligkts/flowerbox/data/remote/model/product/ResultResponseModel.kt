package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class ResultResponseModel(
    @Json(name = "data")
    val `data`: DataResponseModel
)
