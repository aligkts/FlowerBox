package com.aligkts.flowerbox.internal.extension

import com.aligkts.flowerbox.uimodel.FilterItemUiModel

/**
 * Created by Ali Göktaş on 16,April,2021
 */

fun List<FilterItemUiModel>.getFilterRequestQuery(): String {
    var query = "?"
    this.forEach { filterItem ->
        val selectedValues = filterItem.values.filter { it.isSelected }
        selectedValues.forEach { valueItem ->
            query += valueItem.group.requestFieldName.plus("=").plus(valueItem.id.toString())
            if (selectedValues.iterator().hasNext()) {
                query += "&"
            }
        }
    }
    return query.removeAmpersandFromLastCharIfExists()
}
