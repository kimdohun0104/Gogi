package com.deepthought.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deepthought.local.dao.ExpenditureDao
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity

@Database(
    entities = [
        ExpenditureEntity::class,
        ExpenditureCategoryEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun expenditureDao(): ExpenditureDao
}