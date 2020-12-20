package com.deepthought.expendituredetail

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureDetailState(
    val a: String = ""
) : KindaState

sealed class ExpenditureDetailEvent: KindaEvent {

}

sealed class ExpenditureDetailSideEffect : KindaSideEffect {

}