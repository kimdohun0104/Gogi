package com.deepthought.expendituredetail

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureDetailViewModel :
    KindaViewModel<ExpenditureDetailState, ExpenditureDetailEvent, ExpenditureDetailSideEffect>(
        initialState = ExpenditureDetailState()
    ) {

    override val reducer: KindaReducer<ExpenditureDetailState, ExpenditureDetailEvent, ExpenditureDetailSideEffect>
        get() = buildReducer { }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureDetailState, ExpenditureDetailEvent, ExpenditureDetailSideEffect>
        get() = buildSideEffectHandler { }
}