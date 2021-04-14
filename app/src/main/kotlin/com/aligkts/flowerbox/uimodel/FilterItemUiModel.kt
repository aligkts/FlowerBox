package com.aligkts.flowerbox.uimodel

import com.aligkts.flowerbox.base.ListAdapterItem

/**
 * Created by Ali Göktaş on 14,April,2021
 */
data class FilterItemUiModel(
    override val id: Long,
    val categoryName: String,
    val values: List<FilterValueItemUiModel>
) : ListAdapterItem
