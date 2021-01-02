package com.deepthought.bridge

import com.deepthought.repository.ExpenditureRepository

class GetTotalPriceOfExpendituresUseCase(
    private val expenditureRepository: ExpenditureRepository
) {

    suspend operator fun invoke(): Int {
        return expenditureRepository.getTotalPriceOfExpenditures()
    }
}