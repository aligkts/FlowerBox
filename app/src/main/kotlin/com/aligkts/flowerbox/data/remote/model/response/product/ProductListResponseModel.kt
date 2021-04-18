package com.aligkts.flowerbox.data.remote.model.response.product

import com.aligkts.flowerbox.data.remote.BaseResponseModel
import com.aligkts.flowerbox.internal.extension.find
import com.aligkts.flowerbox.uimodel.ProductItemUiModel
import com.aligkts.flowerbox.uimodel.enum.DeliveryBadgeType
import com.squareup.moshi.Json

data class ProductListResponseModel(
    @Json(name = "error")
    val error: ErrorResponseModel,
    @Json(name = "result")
    val result: ResultResponseModel
) : BaseResponseModel() {

    fun toUiModel(): List<ProductItemUiModel> {
        return result.data.products.map { item ->
            ProductItemUiModel(
                id = item.id,
                imagePath = item.image,
                title = item.name,
                oldPrice = item.price.old,
                currentPrice = item.price.current.toString(),
                badgeText = item.deliveryBadgeText,
                badgeTextColorRes = (DeliveryBadgeType::value.find(item.deliveryBadgeType) ?: DeliveryBadgeType.FREE_DELIVERY).color()
            )
        }
    }
}
