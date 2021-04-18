package com.aligkts.flowerbox.data.remote.model.product

import com.squareup.moshi.Json

data class ProductResponseModel(
    @Json(name = "adsModel")
    val adsModel: Any?,
    @Json(name = "code")
    val code: String,
    @Json(name = "dateBasedDiscount")
    val dateBasedDiscount: Any?,
    @Json(name = "deliveryBadgeText")
    val deliveryBadgeText: String,
    @Json(name = "deliveryBadgeType")
    val deliveryBadgeType: Int,
    @Json(name = "deliveryChargeMessage")
    val deliveryChargeMessage: Any?,
    @Json(name = "deliveryChargeText")
    val deliveryChargeText: String?,
    @Json(name = "entryId")
    val entryId: Long,
    @Json(name = "id")
    val id: Long,
    @Json(name = "image")
    val image: String,
    @Json(name = "information")
    val information: String,
    @Json(name = "installment")
    val installment: Boolean,
    @Json(name = "installmentText")
    val installmentText: String?,
    @Json(name = "isDigital")
    val isDigital: Boolean,
    @Json(name = "isDiscountAvailable")
    val isDiscountAvailable: Boolean,
    @Json(name = "isHaveVase")
    val isHaveVase: Boolean,
    @Json(name = "isHaveVaseText")
    val isHaveVaseText: String,
    @Json(name = "isMarketplace")
    val isMarketplace: Boolean,
    @Json(name = "isOriginal")
    val isOriginal: Boolean,
    @Json(name = "isRequiredLegalPermission")
    val isRequiredLegalPermission: Boolean,
    @Json(name = "isSubscription")
    val isSubscription: Boolean,
    @Json(name = "largeImage")
    val largeImage: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "marketplaceBranch")
    val marketplaceBranch: Any?,
    @Json(name = "mediumImage")
    val mediumImage: String,
    @Json(name = "mostSellestProduct")
    val mostSellestProduct: Boolean,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: PriceResponseModel,
    @Json(name = "productDeliveryCity")
    val productDeliveryCity: ProductDeliveryCity,
    @Json(name = "productGroupId")
    val productGroupId: Int,
    @Json(name = "productType")
    val productType: Int,
    @Json(name = "responseTimeText")
    val responseTimeText: String?,
    @Json(name = "reviewCount")
    val reviewCount: Int,
    @Json(name = "reviewRating")
    val reviewRating: Double,
    @Json(name = "role")
    val role: Any?,
    @Json(name = "showPriceDroppedTagAtFavoritePage")
    val showPriceDroppedTagAtFavoritePage: Boolean,
    @Json(name = "smallImage")
    val smallImage: String,
    @Json(name = "variantCode")
    val variantCode: String,
    @Json(name = "webLink")
    val webLink: String,
    @Json(name = "xlargeImage")
    val xlargeImage: String
)
