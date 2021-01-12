package com.deepthought.repository

import com.deepthought.local.dao.ExpenditureDao
import com.deepthought.local.entity.ExpenditureEntity

interface ExpenditureRepository {

    suspend fun insertExpenditure(expenditureEntity: ExpenditureEntity)

    suspend fun getExpenditures(forceUpdate: Boolean): List<ExpenditureEntity>

    suspend fun getTotalPriceOfExpenditures(): Int
}

class ExpenditureRepositoryImpl(
    private val expenditureDao: ExpenditureDao
) : ExpenditureRepository {

    private val cachedExpenditures: ArrayList<ExpenditureEntity> = arrayListOf()

    override suspend fun insertExpenditure(expenditureEntity: ExpenditureEntity) {
        cachedExpenditures.add(expenditureEntity)
        expenditureDao.insertExpenditure(expenditureEntity)
    }

    override suspend fun getExpenditures(forceUpdate: Boolean): List<ExpenditureEntity> {
        if (forceUpdate || cachedExpenditures.isNullOrEmpty()) {
            val expenditures = expenditureDao.getAllExpenditures()
            cachedExpenditures.clear()
            cachedExpenditures.addAll(expenditures)
        }

        return cachedExpenditures
    }

    override suspend fun getTotalPriceOfExpenditures(): Int {
        return expenditureDao.getTotalPriceOfExpenditures()
    }
}