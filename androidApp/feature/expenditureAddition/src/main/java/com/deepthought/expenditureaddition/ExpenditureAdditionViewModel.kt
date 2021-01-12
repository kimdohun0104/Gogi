package com.deepthought.expenditureaddition

import com.deepthought.bridge.InsertExpenditureUseCase
import com.deepthought.bridge.model.Expenditure
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
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
                val copied = copy(expenditureCategory = it.expenditureCategory)
                next(copied.copy(isConfirmEnabled = isConfirmEnabled(copied)))
            }

            whenEvent<ExpenditureAdditionEvent.OnSelectPaymentDate> {
                val copied = copy(paymentDate = it.paymentDate)
                next(copied.copy(isConfirmEnabled = isConfirmEnabled(copied)))
            }

            whenEvent<ExpenditureAdditionEvent.OnEnterName> {
                val copied = copy(name = it.name)
                next(copied.copy(isConfirmEnabled = isConfirmEnabled(copied)))
            }

            whenEvent<ExpenditureAdditionEvent.OnEnterPrice> {
                val copied = copy(price = it.price)
                next(copied.copy(isConfirmEnabled = isConfirmEnabled(copied)))
            }

            whenEvent<ExpenditureAdditionEvent.AttemptInsertExpenditure> {
                if (paymentDate == null || expenditureCategory == null) {
                    return@whenEvent noChange()
                }

                dispatch(
                    ExpenditureAdditionSideEffect.InsertExpenditure(
                        Expenditure(
                            id = 0,
                            paymentDate = paymentDate,
                            name = name,
                            price = price.toIntOrNull() ?: 0,
                            expenditureCategory = expenditureCategory
                        )
                    )
                )
            }

            whenEvent<ExpenditureAdditionEvent.OnConfirm> {
                next(copy(popBackStack = Event(Unit)))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>
        get() = buildSideEffectHandler {
            whenSideEffect<ExpenditureAdditionSideEffect.InsertExpenditure> {
                insertExpenditure(it.expenditure)
                ExpenditureAdditionEvent.OnConfirm
            }
        }

    private fun isConfirmEnabled(state: ExpenditureAdditionState): Boolean =
        state.name.isNotBlank() && state.price.isNotBlank()
            && state.expenditureCategory != null && state.paymentDate != null

}