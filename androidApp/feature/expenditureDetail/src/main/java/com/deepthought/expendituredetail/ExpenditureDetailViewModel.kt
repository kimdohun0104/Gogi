package com.deepthought.expendituredetail

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureDetailViewModel :
    KindaViewModel<ExpenditureDetailState, ExpenditureDetailEvent, ExpenditureDetailSideEffect>(
        initialState = ExpenditureDetailState(),
        reducer = buildReducer {
        },
        sideEffectHandler = buildSideEffectHandler {
        }
    )