package com.aligkts.flowerbox.scene.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseBindingActivity
import com.aligkts.flowerbox.databinding.ActivityMainBinding
import com.aligkts.flowerbox.internal.extension.observeNonNull
import com.aligkts.flowerbox.internal.extension.showPopup
import com.aligkts.flowerbox.navigation.NavigationCommand

class MainActivity : BaseBindingActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId get() = R.layout.activity_main

    val navController: NavController by lazy { findNavController(R.id.main_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        observeNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun observeNavigation() {
        viewModel.navigation.observeNonNull(this) {
            it.getContentIfNotHandled()?.let { command ->
                handleNavigation(command)
            }
        }
    }

    private fun handleNavigation(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.ToDirection -> navController.navigate(command.directions)
            is NavigationCommand.ToDeepLink -> navController.navigate(command.deepLink.toUri())
            is NavigationCommand.Popup -> showPopup(command.model, command.callback)
            is NavigationCommand.Back -> navController.navigateUp()
        }
    }

    private fun shouldHideBottomNav(args: Bundle?): Boolean {
        return args?.getBoolean(getString(R.string.arg_hide_bottom_nav)) == true
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
