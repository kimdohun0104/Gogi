package com.deepthought.expenditurecategoryaddition

import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureCategoryAdditionState(
    val categoryName: String = "",

    val isCompleteEnable: Boolean = false,

    val popBackStack: Event<Unit> = Event()
) : KindaState

sealed class ExpenditureCategoryAdditionEvent : KindaEvent {

    object OnClickAddCategory : ExpenditureCategoryAdditionEvent()

    data class OnEnterCategoryName(val categoryName: String) : ExpenditureCategoryAdditionEvent()

    object PopBackStack : ExpenditureCategoryAdditionEvent()
}

sealed class ExpenditureCategoryAdditionSideEffect : KindaSideEffect {
    data class InsertExpenditureCategory(
        val categoryName: String
    ) : ExpenditureCategoryAdditionSideEffect()
}