package com.deepthought.gogi.androidApp.ui.splash

import com.deepthought.gogi.preference.PREF_USER_NAME
import com.deepthought.gogi.preference.PreferenceStorage
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler
import kotlinx.coroutines.delay

class SplashViewModel(
    private val preferenceStorage: PreferenceStorage
) : KindaViewModel<SplashState, SplashEvent, SplashSideEffect>(
    initialState = SplashState(),
    reducer = buildReducer {
        whenEvent<SplashEvent.AttemptGetUserNameAndDelay> {
            dispatch(SplashSideEffect.GetUserNameAndDelay(delay = it.delay))
        }

        whenEvent<SplashEvent.NavigateHome> {
            next(copy(navigateHome = Event(Unit)))
        }

        whenEvent<SplashEvent.NavigateInputName> {
            next(copy(navigateInputName = Event(Unit)))
        }
    },
    sideEffectHandler = buildSideEffectHandler {
        whenSideEffect<SplashSideEffect.GetUserNameAndDelay> {
            delay(it.delay)

            val userName = preferenceStorage.getString(PREF_USER_NAME)
            if (userName.isNullOrBlank()) {
                SplashEvent.NavigateInputName
            } else {
                SplashEvent.NavigateHome
            }

        }
    }
) {
    init {
        intent(SplashEvent.AttemptGetUserNameAndDelay(1300L))
    }
}