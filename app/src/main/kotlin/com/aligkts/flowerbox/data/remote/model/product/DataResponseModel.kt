package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class DataResponseModel(
    @Json(name = "backgroundColor")
    val backgroundColor: String?,
    @Json(name = "banners")
    val banners: String?,
    @Json(name = "branch")
    val branch: String?,
    @Json(name = "categoryName")
    val categoryName: String?,
    @Json(name = "filter")
    val filter: String?,
    @Json(name = "hasOldPrice")
    val hasOldPrice: Boolean,
    @Json(name = "isAlternate")
    val isAlternate: Boolean,
    @Json(name = "mainFilter")
    val mainFilter: MainFilterResponseModel,
    @Json(name = "message")
    val message: String?,
    @Json(name = "productCount")
    val productCount: Int,
    @Json(name = "products")
    val products: List<ProductResponseModel>,
    @Json(name = "storeId")
    val storeId: String?,
    @Json(name = "subCategoryModel")
    val subCategoryModel: SubCategoryResponseModel,
    @Json(name = "title")
    val title: String?
)
