package com.deepthought.expenditureaddition

import com.deepthought.bridge.InsertExpenditureUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureAdditionViewModel(
    private val insertExpenditure: InsertExpenditureUseCase
) : KindaViewModel<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>(
    initialState = ExpenditureAdditionState()
) {

    override val reducer: KindaReducer<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>
        get() = buildReducer {
            whenEvent<ExpenditureAdditionEvent.OnSelectExpenditureCategory> {
                next(copy(expenditureCategory = it.expenditureCategory))
            }

            whenEvent<ExpenditureAdditionEvent.OnSelectPaymentDate> {
                next(copy(paymentDate = it.paymentDate))
            }

            whenEvent<ExpenditureAdditionEvent.OnEnterName> {
                next(copy(name = it.name))
            }

            whenEvent<ExpenditureAdditionEvent.OnEnterPrice> {
                next(copy(price = it.price))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>
        get() = buildSideEffectHandler { }
}