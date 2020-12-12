package com.deepthought.home

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class HomeState(
    val userName: String = "",
    val totalExpenditure: Int = 0,

    val hasNewNotification: Boolean = false
) : KindaState

sealed class HomeEvent : KindaEvent {
}

sealed class HomeSideEffect : KindaSideEffect {
}