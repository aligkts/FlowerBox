package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class DynamicFilterResponseModel(
    @Json(name = "clearLink")
    val clearLink: String?,
    @Json(name = "detailId")
    val detailId: Int,
    @Json(name = "dropdownInfo")
    val dropdownInfo: String?,
    @Json(name = "dropdownTitle")
    val dropdownTitle: String?,
    @Json(name = "filterBehaviour")
    val filterBehaviour: Int,
    @Json(name = "filterType")
    val filterType: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "isMainCategory")
    val isMainCategory: Boolean,
    @Json(name = "isReload")
    val isReload: Boolean,
    @Json(name = "isRemovableDetail")
    val isRemovableDetail: Boolean,
    @Json(name = "name")
    val name: String,
    @Json(name = "sequence")
    val sequence: Int,
    @Json(name = "urlTag")
    val urlTag: String?,
    @Json(name = "values")
    val values: List<ValueResponseModel>
)
