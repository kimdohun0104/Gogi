package com.deepthought.gogi.preference

import platform.Foundation.NSUserDefaults

actual class PreferenceStorageImpl : PreferenceStorage {

    private val userDefaults: NSUserDefaults by lazy {
        NSUserDefaults()
    }

    override fun getInt(key: String): Int? =
        if (containsKey(key)) {
            userDefaults.integerForKey(key).toInt()
        } else {
            null
        }

    override fun getInt(key: String, defaultValue: Int): Int =
        if (containsKey(key)) {
            userDefaults.integerForKey(key).toInt()
        } else {
            defaultValue
        }

    override fun setInt(key: String, value: Int): Int {
        userDefaults.setInteger(value.toLong(), key)
        return value
    }

    override fun getString(key: String): String? =
        if (containsKey(key)) {
            userDefaults.stringForKey(key)
        } else {
            null
        }

    override fun getString(key: String, defaultValue: String): String =
        if (containsKey(key)) {
            userDefaults.stringForKey(key) ?: defaultValue
        } else {
            defaultValue
        }

    override fun setString(key: String, value: String): String {
        userDefaults.setObject(value, key)
        return value
    }

    override fun getDouble(key: String): Double? =
        if (containsKey(key)) {
            userDefaults.doubleForKey(key)
        } else {
            null
        }

    override fun getDouble(key: String, defaultValue: Double): Double =
        if (containsKey(key)) {
            userDefaults.doubleForKey(key)
        } else {
            defaultValue
        }

    override fun setDouble(key: String, value: Double): Double {
        userDefaults.setDouble(value, key)
        return value
    }

    private fun containsKey(key: String): Boolean =
        userDefaults.objectForKey(key) != null
}