package com.deepthought.expenditureaddition

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureAdditionViewModel :
    KindaViewModel<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>(
        initialState = ExpenditureAdditionState(),
        reducer = buildReducer {
        },
        sideEffectHandler = buildSideEffectHandler {
        }
    )