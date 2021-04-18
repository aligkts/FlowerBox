package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.squareup.moshi.Json

data class ProductDeliveryCity(
    @Json(name = "deliveryCityImage")
    val deliveryCityImage: String,
    @Json(name = "isSendToSingleCity")
    val isSendToSingleCity: Boolean
) : BaseResponseModel()
