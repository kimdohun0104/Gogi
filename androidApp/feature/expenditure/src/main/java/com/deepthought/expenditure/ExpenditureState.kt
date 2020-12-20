package com.deepthought.expenditure

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureState(
    val a: String = ""
) : KindaState

sealed class ExpenditureEvent: KindaEvent {

}

sealed class ExpenditureSideEffect : KindaSideEffect {

}