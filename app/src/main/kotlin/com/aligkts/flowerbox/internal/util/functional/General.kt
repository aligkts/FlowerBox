package com.aligkts.flowerbox.internal.util.functional

fun <T> lazyThreadSafetyNone(initializer: () -> T):
    Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
