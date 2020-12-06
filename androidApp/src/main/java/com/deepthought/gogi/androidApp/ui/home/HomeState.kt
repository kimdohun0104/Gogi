package com.deepthought.gogi.androidApp.ui.home

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class HomeState(
    val temp: String = ""
) : KindaState

sealed class HomeEvent : KindaEvent {
}

sealed class HomeSideEffect : KindaSideEffect {
}