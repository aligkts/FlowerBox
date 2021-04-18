package com.aligkts.flowerbox.scene.splash

import android.os.Bundle
import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseBindingActivity
import com.aligkts.flowerbox.databinding.ActivitySplashBinding
import com.aligkts.flowerbox.internal.extension.withDelay
import com.aligkts.flowerbox.scene.main.MainActivity

class SplashActivity : BaseBindingActivity<SplashViewModel, ActivitySplashBinding>() {

    override val layoutId get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        { startMainActivity() }.withDelay()
    }

    private fun startMainActivity() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }
}
