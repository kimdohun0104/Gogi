package com.deepthought.home

import com.deepthought.bridge.model.Expenditure
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class HomeState(
    val userName: String = "",
    val totalExpenditure: Int = 0,

    val todayExpenditures: List<Expenditure> = emptyList(),
    val paidExpenditures: List<Expenditure> = emptyList(),
    val scheduledExpenditures: List<Expenditure> = emptyList(),

    val hasNewNotification: Boolean = false,
    val hasExpenditure: Boolean = false,

    val navigateInputName: Event<Unit> = Event()
) : KindaState

sealed class HomeEvent : KindaEvent {
    object AttemptGetExpenditures : HomeEvent()

    object SetUserName : HomeEvent()
    data class SetExpenditures(
        val today: List<Expenditure>,
        val paid: List<Expenditure>,
        val scheduled: List<Expenditure>,
        val totalExpenditure: Int,
        val hasExpenditure: Boolean
    ) : HomeEvent()
}

sealed class HomeSideEffect : KindaSideEffect {
    object GetExpenditures : HomeSideEffect()
}