package com.deepthought.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.deepthought.local.dao.ExpenditureCategoryDao
import com.deepthought.local.dao.ExpenditureDao
import com.deepthought.local.entity.ExpenditureCategoryEntity
import com.deepthought.local.entity.ExpenditureEntity
import com.deepthought.local.entity.PaymentDateEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Database(
    entities = [
        ExpenditureEntity::class,
        ExpenditureCategoryEntity::class
    ],
    exportSchema = false,
    version = 2
)
@TypeConverters(DatabaseTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun expenditureDao(): ExpenditureDao

    abstract fun expenditureCategoryDao(): ExpenditureCategoryDao
}


class DatabaseTypeConverter {

    @TypeConverter
    fun fromStringToExpenditureCategory(string: String) =
        Json.decodeFromString<ExpenditureCategoryEntity>(string)

    @TypeConverter
    fun fromExpenditureCategoryToString(expenditureCategoryEntity: ExpenditureCategoryEntity) =
        Json.encodeToString(expenditureCategoryEntity)

    @TypeConverter
    fun fromStringToPaymentDate(string: String) =
        Json.decodeFromString<PaymentDateEntity>(string)

    @TypeConverter
    fun fromPaymentDateToString(paymentDateEntity: PaymentDateEntity) =
        Json.encodeToString(paymentDateEntity)
}