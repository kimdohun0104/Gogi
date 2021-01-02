package com.deepthought.bridge

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.mapper.toExpenditure
import com.deepthought.repository.ExpenditureRepository
import java.util.*

class GetPaidExpendituresUseCase(
    private val expenditureRepository: ExpenditureRepository
) {

    suspend operator fun invoke(forceUpdate: Boolean = false): List<Expenditure> {
        val expenditures = expenditureRepository.getExpenditures(forceUpdate)
        val todayDate = Calendar.getInstance()[Calendar.DATE]

        return expenditures.filter { it.paymentDate < todayDate }
            .map { it.toExpenditure() }
            .sortedBy { it.paymentDate }
    }
}