package com.deepthought.bridge.model.mapper

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity

fun ExpenditureEntity.toExpenditure() =
    Expenditure(
        paymentDate = paymentDate.toPaymentDate(),
        name = name,
        price = price,
        expenditureCategory = expenditureCategory.toExpenditureCategory()
    )
