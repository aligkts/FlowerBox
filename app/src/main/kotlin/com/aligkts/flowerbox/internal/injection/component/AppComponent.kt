package com.aligkts.flowerbox.internal.injection.component

import com.aligkts.flowerbox.internal.injection.DaggerApplication
import com.aligkts.flowerbox.internal.injection.module.ActivitiesModule
import com.aligkts.flowerbox.internal.injection.module.AppModule
import com.aligkts.flowerbox.internal.injection.module.FragmentsModule
import com.aligkts.flowerbox.internal.injection.module.NetworkModule
import com.aligkts.flowerbox.internal.injection.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<DaggerApplication>
}
