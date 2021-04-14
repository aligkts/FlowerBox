package com.aligkts.flowerbox.uimodel

import androidx.annotation.ColorRes
import com.aligkts.flowerbox.base.ListAdapterItem

/**
 * Created by Ali Göktaş on 13,April,2021
 */
data class ProductItemUiModel(
    override val id: Long,
    val imagePath: String,
    val title: String,
    val badgeText: String,
    @ColorRes val badgeTextColorRes: Int,
    val oldPrice: Double,
    val currentPrice: String
) : ListAdapterItem
