package com.deepthought.expenditure.item

import com.deepthought.bridge.model.ExpenditureCategory

data class ExpenditureCategoryItem(

    val expenditureCategory: ExpenditureCategory,
    var isEnabled: Boolean
)