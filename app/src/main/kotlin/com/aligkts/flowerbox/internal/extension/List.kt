package com.aligkts.flowerbox.internal.extension

import com.aligkts.flowerbox.uimodel.FilterValueItemUiModel

/**
 * Created by Ali Göktaş on 16,April,2021
 */

fun List<FilterValueItemUiModel>.getFilterRequestQuery(): String {
    var query = "?"
    this.forEach { item ->
        query += item.group.requestFieldName.plus("=").plus(item.id.toString())
        if (this.last() != item) {
            query += "&"
        }
    }
    return query
}
