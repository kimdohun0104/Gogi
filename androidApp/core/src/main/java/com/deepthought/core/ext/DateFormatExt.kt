package com.deepthought.core.ext

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDefaultDateFormat(): String {
    return SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(Date(this))
}