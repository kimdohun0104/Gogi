package com.deepthought.bridge

import com.deepthought.local.dao.ExpenditureDao

class GetTodayExpenditureUseCase(
    private val expenditureDao: ExpenditureDao
) {

    suspend operator fun invoke() {
        val expenditures = expenditureDao.getAllExpenditures()
    }
}