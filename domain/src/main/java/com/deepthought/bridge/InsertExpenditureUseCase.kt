package com.deepthought.bridge

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.mapper.toEntity
import com.deepthought.repository.ExpenditureRepository

class InsertExpenditureUseCase(
    private val expenditureRepository: ExpenditureRepository
) {

    suspend operator fun invoke(expenditure: Expenditure) {
        expenditureRepository.insertExpenditure(expenditure.toEntity())
    }
}