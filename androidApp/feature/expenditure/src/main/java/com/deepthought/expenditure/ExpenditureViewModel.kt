package com.deepthought.expenditure

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureViewModel :
    KindaViewModel<ExpenditureState, ExpenditureEvent, ExpenditureSideEffect>(
        initialState = ExpenditureState()
    ) {

    override val reducer: KindaReducer<ExpenditureState, ExpenditureEvent, ExpenditureSideEffect>
        get() = buildReducer { }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureState, ExpenditureEvent, ExpenditureSideEffect>
        get() = buildSideEffectHandler { }
}