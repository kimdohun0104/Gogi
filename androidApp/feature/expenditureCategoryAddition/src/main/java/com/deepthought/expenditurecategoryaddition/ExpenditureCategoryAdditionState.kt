package com.deepthought.expenditurecategoryaddition

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureCategoryAdditionState(
    val a: String = ""
) : KindaState

sealed class ExpenditureCategoryAdditionEvent: KindaEvent {

}

sealed class ExpenditureCategoryAdditionSideEffect : KindaSideEffect {

}