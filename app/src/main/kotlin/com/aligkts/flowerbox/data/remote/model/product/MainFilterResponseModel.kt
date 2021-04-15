package com.aligkts.flowerbox.data.remote.model.product

import com.aligkts.flowerbox.internal.extension.find
import com.aligkts.flowerbox.uimodel.FilterItemUiModel
import com.aligkts.flowerbox.uimodel.FilterValueItemUiModel
import com.aligkts.flowerbox.uimodel.enum.FilterGroupType
import com.squareup.moshi.Json

data class MainFilterResponseModel(
    @Json(name = "dynamicFilter")
    val dynamicFilter: List<DynamicFilterResponseModel>,
    @Json(name = "sort")
    val sort: List<SortResponseModel>
) {

    fun toUiModel(): List<FilterItemUiModel> {
        return dynamicFilter.map { filterItem ->
            FilterItemUiModel(
                id = filterItem.detailId,
                categoryName = filterItem.name,
                isSingleChoice = filterItem.isMainCategory,
                values = filterItem.values.map { valueItem ->
                    FilterValueItemUiModel(
                        id = valueItem.id,
                        name = valueItem.name,
                        group = FilterGroupType::value.find(valueItem.group)
                            ?: FilterGroupType.DETAIL_LIST
                    )
                }
            )
        }
    }
}
