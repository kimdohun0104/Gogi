package com.deepthought.gogi.androidApp.ext

import java.text.DecimalFormat

fun Long.toDefaultPriceFormat(): String =
    DecimalFormat("#,###").format(this)
