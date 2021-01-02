package com.deepthought.gogi.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceStorageImpl(
    private val context: Context
): PreferenceStorage {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences("gogi", Context.MODE_PRIVATE)
    }

    override fun getInt(key: String): Int? =
        if (preferences.contains(key)) {
            preferences.getInt(key, 0)
        } else {
            null
        }

    override fun getInt(key: String, defaultValue: Int): Int =
        preferences.getInt(key, defaultValue)

    override fun setInt(key: String, value: Int): Int {
        preferences.edit().putInt(key, value).apply()
        return value
    }

    override fun getString(key: String): String? =
        if (preferences.contains(key)) {
            preferences.getString(key, "")
        } else {
            null
        }

    override fun getString(key: String, defaultValue: String): String =
        preferences.getString(key, defaultValue) ?: defaultValue

    override fun setString(key: String, value: String): String {
        preferences.edit().putString(key, value).apply()
        return value
    }

    override fun getDouble(key: String): Double? =
        if (preferences.contains(key)) {
            preferences.getFloat(key, 0F).toDouble()
        } else {
            null
        }

    override fun getDouble(key: String, defaultValue: Double): Double =
        preferences.getFloat(key, defaultValue.toFloat()).toDouble()

    override fun setDouble(key: String, value: Double): Double {
        preferences.edit().putFloat(key, value.toFloat()).apply()
        return value
    }
}