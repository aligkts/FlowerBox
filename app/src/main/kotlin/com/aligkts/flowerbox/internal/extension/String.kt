package com.aligkts.flowerbox.internal.extension

/**
 * Created by Ali Göktaş on 18,April,2021
 */

fun String.removeAmpersandFromLastIndexIfExists(): String {
    return if (this.last().toString() == "&") {
        this.substring(0, this.length - 1)
    } else {
        this
    }
}
