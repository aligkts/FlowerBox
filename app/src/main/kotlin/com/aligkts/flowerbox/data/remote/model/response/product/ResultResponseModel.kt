package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.squareup.moshi.Json

data class ResultResponseModel(
    @Json(name = "data")
    val `data`: DataResponseModel
) : BaseResponseModel()
