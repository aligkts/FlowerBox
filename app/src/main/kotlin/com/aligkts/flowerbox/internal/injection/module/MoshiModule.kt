package com.aligkts.flowerbox.internal.injection.module

import com.aligkts.flowerbox.internal.util.DateAdapter
import com.aligkts.flowerbox.internal.util.ImageJsonAdapter
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class MoshiModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(ImageJsonAdapter())
            .add(DateAdapter())
            .add(Wrapped.ADAPTER_FACTORY)
            .build()
    }
}
