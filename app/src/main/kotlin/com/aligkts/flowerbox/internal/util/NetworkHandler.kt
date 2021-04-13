package com.aligkts.flowerbox.internal.util

import android.content.Context
import com.aligkts.flowerbox.internal.extension.isNetworkAvailable
import javax.inject.Singleton

@Singleton
class NetworkHandler(private val context: Context) {
    val isConnected: Boolean
        get() = context.isNetworkAvailable()
}
