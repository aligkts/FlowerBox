package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.squareup.moshi.Json

data class DynamicFilterResponseModel(
    @Json(name = "clearLink")
    val clearLink: Any?,
    @Json(name = "detailId")
    val detailId: Long,
    @Json(name = "dropdownInfo")
    val dropdownInfo: Any?,
    @Json(name = "dropdownTitle")
    val dropdownTitle: Any?,
    @Json(name = "filterBehaviour")
    val filterBehaviour: Int,
    @Json(name = "filterType")
    val filterType: Int,
    @Json(name = "id")
    val id: Long,
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
    val urlTag: Any?,
    @Json(name = "values")
    val values: List<ValueResponseModel>
) : BaseResponseModel()