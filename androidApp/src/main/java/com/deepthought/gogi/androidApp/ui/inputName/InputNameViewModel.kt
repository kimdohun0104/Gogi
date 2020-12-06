package com.deepthought.gogi.androidApp.ui.inputName

import android.util.Log
import com.deepthought.gogi.preference.PREF_USER_NAME
import com.deepthought.gogi.preference.PreferenceStorage
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler
import timber.log.Timber

class InputNameViewModel(
    private val preferenceStorage: PreferenceStorage
) : KindaViewModel<InputNameState, InputNameEvent, InputNameSideEffect>(
    initialState = InputNameState(),
    reducer = buildReducer {
        whenEvent<InputNameEvent.OnEnterName> {
            next(copy(name = it.name, isNextBtnEnabled = it.name.isNotBlank()))
        }

        whenEvent<InputNameEvent.OnClickInputNameComplete> {
            preferenceStorage.setString(PREF_USER_NAME, name)
            next(copy(navigateHome = Event(Unit)))
        }
    },
    sideEffectHandler = buildSideEffectHandler {
    }
)