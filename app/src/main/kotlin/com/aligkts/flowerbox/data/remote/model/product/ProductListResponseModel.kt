package com.aligkts.flowerbox.data.remote.model.product

import com.aligkts.flowerbox.uimodel.ProductListUiModel
import com.squareup.moshi.Json

data class ProductListResponseModel(
    @Json(name = "error")
    val error: ErrorResponseModel,
    @Json(name = "result")
    val result: ResultResponseModel
) {

    fun toUiModel() = ProductListUiModel(
        products = result.data.products.toString()
    )
}
