package com.deepthought.expenditurecategoryselection

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureCategorySelectionState(
    val a: String = ""
) : KindaState

sealed class ExpenditureCategorySelectionEvent: KindaEvent {

}

sealed class ExpenditureCategorySelectionSideEffect : KindaSideEffect {

}