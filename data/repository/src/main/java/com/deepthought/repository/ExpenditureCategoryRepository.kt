package com.deepthought.repository

import com.deepthought.local.dao.ExpenditureCategoryDao
import com.deepthought.local.entity.ExpenditureCategoryEntity

interface ExpenditureCategoryRepository {

    suspend fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity)

    suspend fun getExpenditureCategories(forceUpdate: Boolean): List<ExpenditureCategoryEntity>
}

class ExpenditureCategoryRepositoryImpl(
    private val expenditureCategoryDao: ExpenditureCategoryDao
) : ExpenditureCategoryRepository {

    private val cachedExpenditureCategories = arrayListOf<ExpenditureCategoryEntity>()

    override suspend fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity) {
        cachedExpenditureCategories.add(expenditureCategory)
        expenditureCategoryDao.insertExpenditureCategory(expenditureCategory)
    }

    override suspend fun getExpenditureCategories(forceUpdate: Boolean): List<ExpenditureCategoryEntity> {
        if (forceUpdate || cachedExpenditureCategories.isNullOrEmpty()) {
            val expenditureCategories = expenditureCategoryDao.selectAllExpenditureCategories()
            cachedExpenditureCategories.clear()
            cachedExpenditureCategories.addAll(expenditureCategories)
        }

        return cachedExpenditureCategories
    }
}