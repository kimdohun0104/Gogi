package com.deepthought.gogi.androidApp.ui.splash

import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class SplashState(
    val navigateHome: Event<Unit> = Event(),
    val navigateInputName: Event<Unit> = Event()
) : KindaState

sealed class SplashEvent : KindaEvent {
    data class AttemptGetUserNameAndDelay(val delay: Long) : SplashEvent()

    object NavigateHome : SplashEvent()
    object NavigateInputName : SplashEvent()
}

sealed class SplashSideEffect : KindaSideEffect {
    data class GetUserNameAndDelay(val delay: Long) : SplashSideEffect()
}