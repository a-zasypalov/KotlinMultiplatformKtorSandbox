package com.gaoyun.ktormpp.date

import java.text.SimpleDateFormat
import java.util.*

actual class PlatformDate {
    actual fun getCurrentDate(): String {
        val date = Calendar.getInstance().time
        val df = SimpleDateFormat(dateUtilities.dateFormat, Locale.getDefault())
        return df.format(date)
    }
}