package com.aligkts.flowerbox.internal.extension

import com.aligkts.flowerbox.internal.util.Constant
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.formatDate(format: String, locale: Locale = Constant.Locale.LOCALE_ENGLISH): String {
    val dateFormat = SimpleDateFormat(format, locale)
    return dateFormat.format(this)
}
