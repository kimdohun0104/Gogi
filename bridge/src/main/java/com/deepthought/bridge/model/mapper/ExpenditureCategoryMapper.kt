package com.deepthought.bridge.model.mapper

import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.local.entity.ExpenditureCategoryEntity

fun ExpenditureCategoryEntity.toExpenditureCategory() =
    ExpenditureCategory(
        id = id,
        name = name
    )

fun ExpenditureCategory.toEntity() =
    ExpenditureCategoryEntity(
        id = id,
        name = name
    )