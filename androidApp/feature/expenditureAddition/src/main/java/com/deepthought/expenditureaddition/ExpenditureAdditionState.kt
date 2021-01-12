package com.deepthought.expenditureaddition

import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.PaymentDate
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class ExpenditureAdditionState(
    val name: String = "",
    val price: String = "",

    val isConfirmEnabled: Boolean = false,

    val paymentDate: PaymentDate? = null,
    val expenditureCategory: ExpenditureCategory? = null,

    val popBackStack: Event<Unit> = Event()
) : KindaState

sealed class ExpenditureAdditionEvent : KindaEvent {
    object AttemptInsertExpenditure : ExpenditureAdditionEvent()

    data class OnSelectExpenditureCategory(
        val expenditureCategory: ExpenditureCategory
    ) : ExpenditureAdditionEvent()

    data class OnSelectPaymentDate(
        val paymentDate: PaymentDate
    ) : ExpenditureAdditionEvent()

    data class OnEnterName(val name: String) : ExpenditureAdditionEvent()

    data class OnEnterPrice(val price: String) : ExpenditureAdditionEvent()

    object OnConfirm : ExpenditureAdditionEvent()
}

sealed class ExpenditureAdditionSideEffect : KindaSideEffect {

    data class InsertExpenditure(
        val expenditure: Expenditure
    ) : ExpenditureAdditionSideEffect()
}