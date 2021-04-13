package com.aligkts.flowerbox.base

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aligkts.flowerbox.internal.util.functional.lazyThreadSafetyNone

/**
 * Created by Ali Göktaş on 13,April,2021
 */
abstract class BaseBindingActivity<VM : BaseAndroidViewModel, B : ViewDataBinding> :
    BaseActivity<VM>() {

    protected val binder by lazyThreadSafetyNone<B> {
        DataBindingUtil.setContentView(this, layoutId)
    }

    @get:LayoutRes
    abstract val layoutId: Int
}
