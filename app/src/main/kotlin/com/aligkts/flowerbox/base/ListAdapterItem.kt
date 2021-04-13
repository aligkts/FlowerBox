package com.aligkts.flowerbox.base

/**
 * Created by Ali Göktaş on 13,April,2021
 */
interface ListAdapterItem {
    val id: Long

    override fun equals(other: Any?): Boolean
}
