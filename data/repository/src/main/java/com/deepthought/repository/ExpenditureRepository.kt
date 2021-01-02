package com.deepthought.repository

import com.deepthought.local.dao.ExpenditureDao
import com.deepthought.local.entity.ExpenditureEntity

interface ExpenditureRepository {

    suspend fun getExpenditures(forceUpdate: Boolean): List<ExpenditureEntity>
}

class ExpenditureRepositoryImpl(
    private val expenditureDao: ExpenditureDao
) : ExpenditureRepository {

    private val cachedExpenditures: ArrayList<ExpenditureEntity> = arrayListOf()

    override suspend fun getExpenditures(forceUpdate: Boolean): List<ExpenditureEntity> {
        if (forceUpdate || cachedExpenditures.isNullOrEmpty()) {
            val expenditures = expenditureDao.getAllExpenditures()
            cachedExpenditures.clear()
            cachedExpenditures.addAll(expenditures)
        }

        return cachedExpenditures
    }
}