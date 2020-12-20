package com.deepthought.expenditure

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureViewModel : KindaViewModel<ExpenditureState, ExpenditureEvent, ExpenditureSideEffect>(
    initialState = ExpenditureState(),
    reducer = buildReducer {
    },
    sideEffectHandler = buildSideEffectHandler {
    }
)