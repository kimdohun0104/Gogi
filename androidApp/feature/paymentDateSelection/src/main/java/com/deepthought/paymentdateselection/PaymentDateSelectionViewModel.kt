package com.deepthought.paymentdateselection

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class PaymentDateSelectionViewModel :
    KindaViewModel<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>(
        initialState = PaymentDateSelectionState()
    ) {

    override val reducer: KindaReducer<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>
        get() = buildReducer { }
    override val sideEffectHandler: KindaSideEffectHandler<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>
        get() = buildSideEffectHandler { }
}