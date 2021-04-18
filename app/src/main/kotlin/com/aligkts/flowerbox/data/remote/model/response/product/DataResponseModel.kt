package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.squareup.moshi.Json

data class DataResponseModel(
    @Json(name = "backgroundColor")
    val backgroundColor: String?,
    @Json(name = "banners")
    val banners: Any?,
    @Json(name = "branch")
    val branch: Any?,
    @Json(name = "categoryName")
    val categoryName: String?,
    @Json(name = "filter")
    val filter: Any?,
    @Json(name = "hasOldPrice")
    val hasOldPrice: Boolean,
    @Json(name = "isAlternate")
    val isAlternate: Boolean,
    @Json(name = "mainFilter")
    val mainFilter: MainFilterResponseModel,
    @Json(name = "message")
    val message: Any?,
    @Json(name = "productCount")
    val productCount: Long,
    @Json(name = "products")
    val products: List<ProductResponseModel>,
    @Json(name = "storeId")
    val storeId: Any?,
    @Json(name = "subCategoryModel")
    val subCategoryModel: SubCategoryResponseModel,
    @Json(name = "title")
    val title: Any?
) : BaseResponseModel()
