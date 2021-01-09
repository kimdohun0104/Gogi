package com.deepthought.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expenditure")
data class ExpenditureEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val paymentDate: PaymentDateEntity,

    val name: String,

    val price: Int,

    val expenditureCategory: ExpenditureCategoryEntity
)