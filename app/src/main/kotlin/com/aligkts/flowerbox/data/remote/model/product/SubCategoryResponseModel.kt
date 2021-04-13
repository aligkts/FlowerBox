package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class SubCategoryResponseModel(
    @Json(name = "shapeType")
    val shapeType: Int,
    @Json(name = "subCategoryList")
    val subCategoryList: List<Any>
)
