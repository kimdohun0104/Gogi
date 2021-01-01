package com.deepthought.expenditurecategoryselection

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureCategorySelectionViewModel :
    KindaViewModel<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>(
    initialState = ExpenditureCategorySelectionState()
) {
    override val reducer: KindaReducer<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>
        get() = buildReducer {  }
    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>
        get() = buildSideEffectHandler {  }

}