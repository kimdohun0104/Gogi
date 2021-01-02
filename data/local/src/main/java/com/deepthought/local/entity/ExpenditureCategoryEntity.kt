package com.deepthought.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ExpenditureCategory")
data class ExpenditureCategoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String
)