package com.deepthought.bridge.model

data class Expenditure(

    val id: Int,
    val paymentDate: PaymentDate,
    val name: String,
    val price: Int,
    val expenditureCategory: ExpenditureCategory
)