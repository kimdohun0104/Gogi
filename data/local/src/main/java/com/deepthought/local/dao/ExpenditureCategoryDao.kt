package com.deepthought.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.deepthought.local.entity.ExpenditureCategoryEntity

@Dao
interface ExpenditureCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpenditureCategory(expenditureCategory: ExpenditureCategoryEntity)


}