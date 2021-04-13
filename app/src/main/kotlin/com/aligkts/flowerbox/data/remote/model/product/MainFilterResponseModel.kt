package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class MainFilterResponseModel(
    @Json(name = "dynamicFilter")
    val dynamicFilter: List<DynamicFilterResponseModel>,
    @Json(name = "sort")
    val sort: List<SortResponseModel>
)
