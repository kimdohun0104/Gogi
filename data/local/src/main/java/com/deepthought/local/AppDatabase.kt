package com.deepthought.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.deepthought.local.dao.ExpenditureDao
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Database(
    entities = [
        ExpenditureEntity::class,
        ExpenditureCategoryEntity::class
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(DatabaseTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun expenditureDao(): ExpenditureDao
}


class DatabaseTypeConverter {

    @TypeConverter
    fun fromStringToExpenditureCategory(string: String) =
        Json.decodeFromString<ExpenditureCategoryEntity>(string)

    @TypeConverter
    fun fromExpenditureCategoryToString(expenditureCategoryEntity: ExpenditureCategoryEntity) =
        Json.encodeToString(expenditureCategoryEntity)
}