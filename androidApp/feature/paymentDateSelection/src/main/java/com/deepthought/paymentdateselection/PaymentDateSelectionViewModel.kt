package com.deepthought.paymentdateselection

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class PaymentDateSelectionViewModel :
    KindaViewModel<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>(
        initialState = PaymentDateSelectionState()
    ) {

    override val reducer: KindaReducer<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>
        get() = buildReducer {
            whenEvent<PaymentDateSelectionEvent.OnEnterPaymentDate> {
                when {
                    isLastDay -> noChange()
                    !isValidDate(it.date) -> next(
                        copy(
                            dateTextFieldErrorText = "1~31의 숫자 중 하나를 입력해주세요",
                            date = it.date,
                            isConfirmEnable = false
                        )
                    )
                    else -> next(
                        copy(
                            date = it.date,
                            isConfirmEnable = it.date.isNotBlank(),
                            dateTextFieldErrorText = ""
                        )
                    )
                }
            }

            whenEvent<PaymentDateSelectionEvent.OnClickLastDay> {
                val toBeIsLastDay = !isLastDay
                next(
                    copy(
                        date = if (toBeIsLastDay) "말" else "0",
                        isLastDay = toBeIsLastDay,
                        isConfirmEnable = toBeIsLastDay
                    )
                )
            }

            whenEvent<PaymentDateSelectionEvent.OnClickConfirm> {
                val selectedDate = if (isLastDay) 31 else date.toInt()
                next(copy(popWithDate = Event(selectedDate)))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>
        get() = buildSideEffectHandler { }

    private fun isValidDate(date: String): Boolean {
        if (date.isBlank()) {
            return true
        }

        val dateInteger = date.trim().toIntOrNull()
        return dateInteger != null && dateInteger in (1..31)
    }
}