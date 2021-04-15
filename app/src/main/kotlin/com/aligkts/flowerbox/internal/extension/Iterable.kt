package com.aligkts.flowerbox.internal.extension

/**
 * Created by Ali Göktaş on 15,April,2021
 */

fun <E> Iterable<E>.replace(old: E, new: E) = map { if (it == old) new else it }
