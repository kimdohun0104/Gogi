package com.deepthought.bridge.model.mapper

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity

fun ExpenditureEntity.toExpenditure() =
    Expenditure(
        id = id,
        paymentDate = paymentDate.toPaymentDate(),
        name = name,
        price = price,
        expenditureCategory = expenditureCategory.toExpenditureCategory()
    )

fun Expenditure.toEntity() =
    ExpenditureEntity(
        id = id,
        paymentDate = paymentDate.toEntity(),
        name = name,
        price = price,
        expenditureCategory = expenditureCategory.toEntity()
    )