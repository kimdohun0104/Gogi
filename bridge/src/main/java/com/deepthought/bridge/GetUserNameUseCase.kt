package com.deepthought.bridge

import com.deepthought.gogi.preference.contract.PREF_USER_NAME
import com.deepthought.gogi.preference.contract.PreferenceStorage

class GetUserNameUseCase(
    private val preferenceStorage: PreferenceStorage
) {
    operator fun invoke(): String? {
        return preferenceStorage.getString(PREF_USER_NAME)
    }
}