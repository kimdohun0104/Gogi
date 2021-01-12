package com.deepthought.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepthought.local.entity.ExpenditureEntity

@Dao
interface ExpenditureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpenditure(expenditure: ExpenditureEntity)

    @Query("SELECT * FROM Expenditure")
    suspend fun getAllExpenditures(): List<ExpenditureEntity>

    @Query("SELECT SUM(price) FROM Expenditure")
    suspend fun getTotalPriceOfExpenditures(): Int
}