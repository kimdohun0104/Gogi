package com.deepthought.expenditurecategoryselection

import com.deepthought.bridge.model.ExpenditureCategory
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureCategorySelectionState(
    val expenditureCategories: List<ExpenditureCategory> = emptyList(),

    val isEdit: Boolean = false
) : KindaState

sealed class ExpenditureCategorySelectionEvent : KindaEvent {

    object AttemptGetExpenditureCategories : ExpenditureCategorySelectionEvent()

    data class SetExpenditureCategories(
        val expenditureCategories: List<ExpenditureCategory>
    ) : ExpenditureCategorySelectionEvent()

    object OnClickEdit : ExpenditureCategorySelectionEvent()
    object OnClickEditComplete : ExpenditureCategorySelectionEvent()
}

sealed class ExpenditureCategorySelectionSideEffect : KindaSideEffect {
    object GetExpenditureCategories : ExpenditureCategorySelectionSideEffect()
}