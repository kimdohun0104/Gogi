package com.deepthought.gogi.preference

interface PreferenceStorage {

    fun getInt(key: String): Int?
    fun getInt(key: String, defaultValue: Int): Int
    fun setInt(key: String, value: Int): Int

    fun getString(key: String): String?
    fun getString(key: String, defaultValue: String): String
    fun setString(key: String, value: String): String

    fun getDouble(key: String): Double?
    fun getDouble(key: String, defaultValue: Double): Double
    fun setDouble(key: String, value: Double): Double
}

expect class PreferenceStorageImpl : PreferenceStorage