package com.deepthought.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class PaymentDateEntity(

    val date: Int,

    val isLastDay: Boolean
)