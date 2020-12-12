package com.deepthought.bridge

import com.deepthought.gogi.preference.PREF_USER_NAME
import com.deepthought.gogi.preference.PreferenceStorage

class SetUserNameUseCase(
    private val preferenceStorage: PreferenceStorage
) {
    operator fun invoke(userName: String) {
        preferenceStorage.setString(PREF_USER_NAME, userName)
    }
}