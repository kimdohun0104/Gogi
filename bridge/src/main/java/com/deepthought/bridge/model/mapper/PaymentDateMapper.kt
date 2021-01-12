package com.deepthought.bridge.model.mapper

import com.deepthought.bridge.model.PaymentDate
import com.deepthought.local.entity.PaymentDateEntity

fun PaymentDateEntity.toPaymentDate() =
    PaymentDate(
        isLastDay = isLastDay,
        date = date
    )

fun PaymentDate.toEntity() =
    PaymentDateEntity(
        date = date,
        isLastDay = isLastDay
    )