package com.aligkts.flowerbox.internal.extension

import android.os.Handler
import android.os.Looper

/**
 * Created by Ali Göktaş on 18,April,2021
 */

fun <R> (() -> R).withDelay(delay: Long = 300L) {
    Handler(Looper.getMainLooper()).postDelayed(
        {
            this.invoke()
        },
        delay
    )
}
