package com.deepthought.repository

import com.deepthought.local.dao.ExpenditureCategoryDao
import com.deepthought.local.entity.ExpenditureCategoryEntity

interface ExpenditureCategoryRepository {

    suspend fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity)
}

class ExpenditureCategoryRepositoryImpl(
    private val expenditureCategoryDao: ExpenditureCategoryDao
) : ExpenditureCategoryRepository {

    override suspend fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity) {
        expenditureCategoryDao.insertExpenditureCategory(expenditureCategory)
    }
}