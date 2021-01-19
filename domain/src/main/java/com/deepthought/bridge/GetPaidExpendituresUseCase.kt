package com.deepthought.bridge

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.mapper.toExpenditure
import com.deepthought.repository.ExpenditureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class GetPaidExpendituresUseCase(
    private val expenditureRepository: ExpenditureRepository
) {

    suspend operator fun invoke(forceUpdate: Boolean = false): List<Expenditure> =
        withContext(Dispatchers.IO) {
            val expenditures = expenditureRepository.getExpenditures(forceUpdate)
            val todayDate = Calendar.getInstance()[Calendar.DATE]

            expenditures.filter { it.paymentDate.date < todayDate }
                .map { it.toExpenditure() }
                .sortedBy { it.paymentDate.date }
        }
}