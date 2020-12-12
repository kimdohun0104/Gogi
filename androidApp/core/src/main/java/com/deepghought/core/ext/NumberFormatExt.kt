package com.deepghought.core

import java.text.DecimalFormat

fun Int.toDefaultPriceFormat(): String =
    DecimalFormat("#,###").format(this)
