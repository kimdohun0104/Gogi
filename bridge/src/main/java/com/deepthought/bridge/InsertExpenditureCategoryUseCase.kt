package com.deepthought.bridge

import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.repository.ExpenditureCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InsertExpenditureCategoryUseCase(
    private val expenditureCategoryRepository: ExpenditureCategoryRepository
) {

    suspend operator fun invoke(categoryName: String) = withContext(Dispatchers.IO) {
        expenditureCategoryRepository.insertExpenditureCategory(
            ExpenditureCategoryEntity(0, categoryName)
        )
    }
}