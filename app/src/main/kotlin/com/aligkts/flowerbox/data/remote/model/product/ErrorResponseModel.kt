package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class ErrorResponseModel(
    @Json(name = "message")
    val message: String?,
    @Json(name = "returnUrl")
    val returnUrl: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: Int
)
