package com.deepthought.paymentdateselection

import com.deepthought.bridge.model.PaymentDate
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class PaymentDateSelectionState(
    val date: String = "",

    val isLastDay: Boolean = false,
    val isConfirmEnable: Boolean = false,

    val dateTextFieldErrorText: String = "",

    val popWithDate: Event<PaymentDate> = Event()
) : KindaState

sealed class PaymentDateSelectionEvent: KindaEvent {
    data class OnEnterPaymentDate(
        val date: String
    ) : PaymentDateSelectionEvent()

    object OnClickLastDay : PaymentDateSelectionEvent()

    object OnClickConfirm : PaymentDateSelectionEvent()
}

sealed class PaymentDateSelectionSideEffect : KindaSideEffect {

}