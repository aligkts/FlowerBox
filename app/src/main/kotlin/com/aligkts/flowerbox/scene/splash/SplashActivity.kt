package com.aligkts.flowerbox.scene.splash

import android.os.Bundle
import com.aligkts.flowerbox.base.BaseActivity
import com.aligkts.flowerbox.scene.main.MainActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startMainActivity()
    }

    private fun startMainActivity() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }
}
