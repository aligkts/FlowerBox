package com.aligkts.flowerbox.internal.extension

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.aligkts.flowerbox.R

val Context.connectivityManager
    get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

fun Context.isNetworkAvailable(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager.activeNetwork
        connectivityManager.apply {
            return getNetworkCapabilities(activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } ?: false
        }
    } else {
        @Suppress("DEPRECATION")
        return connectivityManager.activeNetworkInfo?.isConnected ?: false
    }
}

fun Context?.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.showSingleChoiceDialog(
    title: String,
    values: Array<String>,
    defaultValue: Int,
    buttonAction: (dialog: DialogInterface, which: Int) -> Unit
) {
    AlertDialog.Builder(this, R.style.Theme_MaterialComponents_Light_Dialog)
        .setTitle(title)
        .setCancelable(true)
        .setSingleChoiceItems(values, defaultValue) { dialog, which ->
            buttonAction(dialog, which)
        }
        .create().show()
}

fun Context.showMultipleChoiceDialog(
    title: String,
    values: Array<String>,
    defaultValue: BooleanArray,
    buttonAction: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit
) {
    AlertDialog.Builder(this, R.style.Theme_MaterialComponents_Light_Dialog)
        .setTitle(title)
        .setCancelable(true)
        .setMultiChoiceItems(values, defaultValue) { dialog, which, isChecked ->
            buttonAction(dialog, which, isChecked)
        }
        .create().show()
}
