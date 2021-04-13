package com.aligkts.flowerbox.application

import com.aligkts.flowerbox.BuildConfig
import com.aligkts.flowerbox.internal.injection.DaggerApplication
import com.aligkts.flowerbox.internal.util.TimberTree
import timber.log.Timber

/**
 * Created by Ali Göktaş on 13,April,2021
 */
class MainApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.ENABLE_LOG) {
            Timber.plant(TimberTree.debug)
        } else {
            Timber.plant()
        }
    }
}
