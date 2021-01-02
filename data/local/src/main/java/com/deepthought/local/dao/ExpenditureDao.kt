package com.deepthought.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.deepthought.local.entity.ExpenditureEntity

@Dao
interface ExpenditureDao {

    @Query("SELECT * FROM Expenditure")
    suspend fun getAllExpenditures(): List<ExpenditureEntity>

}