package com.aligkts.flowerbox.uimodel.enum

/**
 * Created by Ali Göktaş on 15,April,2021
 */
enum class FilterGroupType(val value: Int) {
    DETAIL_LIST(1) {
        override val requestFieldName = "detailList"
    },
    CHECK_LIST(2) {
        override val requestFieldName = "checkList"
    },
    PRICE_LIST(3) {
        override val requestFieldName = "priceList"
    };

    open val requestFieldName: String = ""
}
