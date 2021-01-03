package com.deepthought.bridge

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.mapper.toExpenditureCategory
import com.deepthought.repository.ExpenditureCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetExpenditureCategoriesUseCase(
    private val expenditureCategoryRepository: ExpenditureCategoryRepository
) {

    suspend operator fun invoke(forceUpdate: Boolean = false): List<ExpenditureCategory> =
        withContext(Dispatchers.IO) {
            expenditureCategoryRepository.getExpenditureCategories(forceUpdate)
                .map { it.toExpenditureCategory() }
        }
}