package com.deepthought.bridge.model

import java.io.Serializable

data class PaymentDate(
    val date: Int,
    val isLastDay: Boolean
) : Serializable {

    override fun toString(): String =
        if (isLastDay) "말일" else date.toString()
}