package com.deepthought.expenditureaddition

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureAdditionState(
    val a: String = ""
) : KindaState

sealed class ExpenditureAdditionEvent: KindaEvent {

}

sealed class ExpenditureAdditionSideEffect : KindaSideEffect {

}