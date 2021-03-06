package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.squareup.moshi.Json

data class SortResponseModel(
    @Json(name = "count")
    val count: Int,
    @Json(name = "detailValueId")
    val detailValueId: Int,
    @Json(name = "filterQueryString")
    val filterQueryString: Any?,
    @Json(name = "filterQueryStringWithProductGroup")
    val filterQueryStringWithProductGroup: Any?,
    @Json(name = "group")
    val group: Int,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "link")
    val link: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "regionRequired")
    val regionRequired: Boolean,
    @Json(name = "selected")
    val selected: Boolean
) : BaseResponseModel()
