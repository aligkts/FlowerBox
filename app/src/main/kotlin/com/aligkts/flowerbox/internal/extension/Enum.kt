package com.aligkts.flowerbox.internal.extension

/**
 * Created by Ali Göktaş on 14,April,2021
 */

inline fun <reified T : Enum<T>, V> ((T) -> V).find(value: V): T? {
    return enumValues<T>().firstOrNull { this(it) == value }
}
