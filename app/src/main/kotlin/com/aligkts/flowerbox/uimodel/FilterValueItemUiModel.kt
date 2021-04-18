package com.aligkts.flowerbox.uimodel

import com.aligkts.flowerbox.base.ListAdapterItem
import com.aligkts.flowerbox.uimodel.enum.FilterGroupType

/**
 * Created by Ali Göktaş on 14,April,2021
 */
data class FilterValueItemUiModel(
    override val id: Long,
    val name: String,
    val group: FilterGroupType,
    var isSelected: Boolean = false
) : ListAdapterItem
