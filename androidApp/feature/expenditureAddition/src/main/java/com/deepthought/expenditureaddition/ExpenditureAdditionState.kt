package com.deepthought.expenditureaddition

import com.deepthought.bridge.model.ExpenditureCategory
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureAdditionState(
    val name: String = "",
    val price: String = "",

    val paymentDate: Int? = null,

    val expenditureCategory: ExpenditureCategory? = null
) : KindaState

sealed class ExpenditureAdditionEvent : KindaEvent {
    data class OnSelectExpenditureCategory(
        val expenditureCategory: ExpenditureCategory
    ) : ExpenditureAdditionEvent()
}

sealed class ExpenditureAdditionSideEffect : KindaSideEffect {

}