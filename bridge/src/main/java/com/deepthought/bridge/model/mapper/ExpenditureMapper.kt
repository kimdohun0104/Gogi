package com.deepthought.bridge.model.mapper

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity

fun ExpenditureEntity.toExpenditure() =
    Expenditure(
        paymentDate = paymentDate,
        name = name,
        price = price,
        expenditureCategory = expenditureCategory.toExpenditureCategory()
    )

private fun ExpenditureCategoryEntity.toExpenditureCategory() =
    ExpenditureCategory(
        id = id,
        name = name
    )