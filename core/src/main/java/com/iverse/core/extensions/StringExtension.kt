package com.iverse.core.extensions

import java.util.*


fun Date.formatToString(): String {
    val cal = Calendar.getInstance()
    cal.time = this
    val hour = cal.get(Calendar.HOUR_OF_DAY)
    val minute = cal.get(Calendar.MINUTE)

    return "$hour:$minute"
}
