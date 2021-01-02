package com.deepthought.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ExpenditureCategory")
data class ExpenditureCategoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String
)