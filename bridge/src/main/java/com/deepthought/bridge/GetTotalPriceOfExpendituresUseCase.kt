package com.deepthought.bridge

import com.deepthought.repository.ExpenditureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetTotalPriceOfExpendituresUseCase(
    private val expenditureRepository: ExpenditureRepository
) {

    suspend operator fun invoke(): Int = withContext(Dispatchers.IO) {
        expenditureRepository.getTotalPriceOfExpenditures()
    }
}