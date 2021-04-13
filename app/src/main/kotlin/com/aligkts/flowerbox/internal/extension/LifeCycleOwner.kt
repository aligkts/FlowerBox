package com.aligkts.flowerbox.internal.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Ali Göktaş on 13,April,2021
 */

fun <T> LifecycleOwner.liveDataObserver(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}
