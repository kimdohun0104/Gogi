package com.deepghought.core.ext

import java.text.DecimalFormat

fun Int.toDefaultPriceFormat(): String =
    DecimalFormat("#,###").format(this)
