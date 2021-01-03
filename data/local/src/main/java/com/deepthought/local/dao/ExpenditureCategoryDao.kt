package com.deepthought.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepthought.local.entity.ExpenditureCategoryEntity

@Dao
interface ExpenditureCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity)

    @Query("SELECT * FROM ExpenditureCategory")
    suspend fun selectAllExpenditureCategories(): List<ExpenditureCategoryEntity>
}