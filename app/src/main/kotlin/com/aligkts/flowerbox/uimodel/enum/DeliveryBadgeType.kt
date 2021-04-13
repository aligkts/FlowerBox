package com.aligkts.flowerbox.uimodel.enum

import androidx.annotation.ColorRes
import com.aligkts.flowerbox.R

/**
 * Created by Ali Göktaş on 13,April,2021
 */
enum class DeliveryBadgeType(val value: Int) {
    FREE_SHIPPING(1) {
        override fun color(): Int {
            return R.color.orange
        }
    },
    FREE_DELIVERY(3) {
        override fun color(): Int {
            return android.R.color.holo_green_dark
        }
    };

    @ColorRes
    open fun color(): Int = R.color.text_color
}
