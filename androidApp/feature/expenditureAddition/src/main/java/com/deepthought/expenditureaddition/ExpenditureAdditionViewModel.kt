package com.deepthought.expenditureaddition

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureAdditionViewModel :
    KindaViewModel<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>(
        initialState = ExpenditureAdditionState()
    ) {

    override val reducer: KindaReducer<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>
        get() = buildReducer {
            whenEvent<ExpenditureAdditionEvent.OnSelectExpenditureCategory> {
                next(copy(expenditureCategory = it.expenditureCategory))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>
        get() = buildSideEffectHandler { }
}