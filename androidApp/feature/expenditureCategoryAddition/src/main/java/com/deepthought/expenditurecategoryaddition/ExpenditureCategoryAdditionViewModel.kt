package com.deepthought.expenditurecategoryaddition

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureCategoryAdditionViewModel :
    KindaViewModel<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>(
        initialState = ExpenditureCategoryAdditionState()
    ) {
    override val reducer: KindaReducer<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>
        get() = buildReducer {

        }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>
        get() = buildSideEffectHandler {

        }
}