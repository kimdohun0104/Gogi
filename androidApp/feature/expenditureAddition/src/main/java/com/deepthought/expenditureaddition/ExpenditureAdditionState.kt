package com.deepthought.expenditureaddition

import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.PaymentDate
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureAdditionState(
    val name: String = "",
    val price: String = "",

    val paymentDate: PaymentDate? = null,

    val expenditureCategory: ExpenditureCategory? = null
) : KindaState

sealed class ExpenditureAdditionEvent : KindaEvent {
    data class OnSelectExpenditureCategory(
        val expenditureCategory: ExpenditureCategory
    ) : ExpenditureAdditionEvent()

    data class OnSelectPaymentDate(
        val paymentDate: PaymentDate
    ) : ExpenditureAdditionEvent()
}

sealed class ExpenditureAdditionSideEffect : KindaSideEffect {

}