package com.aligkts.flowerbox.internal.injection.module

import com.aligkts.flowerbox.internal.injection.scope.ProductScope
import com.aligkts.flowerbox.scene.filter.FilterBottomSheetFragment
import com.aligkts.flowerbox.scene.filter.FilterModule
import com.aligkts.flowerbox.scene.product.ProductFragment
import com.aligkts.flowerbox.scene.product.ProductModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentsModule {

    @ProductScope
    @ContributesAndroidInjector(modules = [ProductModule::class])
    abstract fun contributeProductFragment(): ProductFragment

    @ProductScope
    @ContributesAndroidInjector(modules = [FilterModule::class])
    abstract fun contributeFilterFragment(): FilterBottomSheetFragment
}
