package com.deepthought.bridge

import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.repository.ExpenditureCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class InsertDefaultExpenditureCategoriesUseCase(
    private val expenditureCategoryRepository: ExpenditureCategoryRepository
) {

    private val defaultExpenditureNames = listOf(
        "문화/컨텐츠",
        "저축",
        "보험료",
        "주거",
        "교육",
        "기부"
    )

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        defaultExpenditureNames.map { name ->
            async {
                expenditureCategoryRepository.insertExpenditureCategory(
                    ExpenditureCategoryEntity(0, name)
                )
            }
        }.awaitAll()
    }
}