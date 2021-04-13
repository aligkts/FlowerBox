package com.aligkts.flowerbox.navigation

import androidx.navigation.NavDirections
import com.aligkts.flowerbox.internal.popup.PopupCallback
import com.aligkts.flowerbox.internal.popup.PopupUiModel

/**
 * A simple sealed class to handle more properly
 * navigation from a [AndroidViewModel]
 */
sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections) : NavigationCommand()
    data class ToDeepLink(val deepLink: String) : NavigationCommand()
    data class Popup(val model: PopupUiModel, val callback: PopupCallback? = null) :
        NavigationCommand()

    object Back : NavigationCommand()
}
