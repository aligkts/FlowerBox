package com.aligkts.flowerbox.internal.injection.module

import com.aligkts.flowerbox.internal.injection.scope.MainScope
import com.aligkts.flowerbox.scene.main.MainActivity
import com.aligkts.flowerbox.scene.main.MainModule
import com.aligkts.flowerbox.scene.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity
}
