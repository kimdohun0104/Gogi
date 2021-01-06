package com.deepthought.paymentdateselection

import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class PaymentDateSelectionState(
    val date: Int = 0
) : KindaState

sealed class PaymentDateSelectionEvent: KindaEvent {

}

sealed class PaymentDateSelectionSideEffect : KindaSideEffect {

}