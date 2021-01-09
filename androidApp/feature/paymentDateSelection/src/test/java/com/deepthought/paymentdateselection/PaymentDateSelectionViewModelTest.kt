package com.deepthought.paymentdateselection

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import org.junit.Assert.*
import org.junit.Test

class PaymentDateSelectionViewModelTest :
    KindaViewModelTest<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect>() {

    override fun buildViewModel(): KindaViewModel<PaymentDateSelectionState, PaymentDateSelectionEvent, PaymentDateSelectionSideEffect> {
        return PaymentDateSelectionViewModel()
    }

    @Test
    fun `OnClickLastDay, When isLastDay is false, Change to true`() {
        PaymentDateSelectionEvent.OnClickLastDay expectState {
            assertTrue(it.isLastDay)
        }
    }

    @Test
    fun `OnEnterPaymentDate, When isLastDay is true, State never change`() {
        viewModel.intent(PaymentDateSelectionEvent.OnClickLastDay)
        PaymentDateSelectionEvent.OnEnterPaymentDate("12") expectState {
            assertEquals("말", it.date)
            assertTrue(it.isLastDay)
        }
    }

    @Test
    fun `OnEnterPaymentDate, When invalid date entered, Set dateTextFieldErrorText`() {
        PaymentDateSelectionEvent.OnEnterPaymentDate("김도훈") expectState {
            assertEquals("1~31의 숫자 중 하나를 입력해주세요", it.dateTextFieldErrorText)
            assertEquals("김도훈", it.date)
            assertFalse(it.isConfirmEnable)
        }
    }

    @Test
    fun `OnEnterPaymentDate, When valid date entered, Set date with entered value`() {
        PaymentDateSelectionEvent.OnEnterPaymentDate("21") expectState {
            assertEquals("21", it.date)
            assertTrue(it.isConfirmEnable)
            assertEquals("", it.dateTextFieldErrorText)
        }
    }

    @Test
    fun `OnClickConfirm, When isLastDay is true, Set popWithDate value 31`() {
        viewModel.intent(PaymentDateSelectionEvent.OnClickLastDay)
        PaymentDateSelectionEvent.OnClickConfirm expectState {
            assertEquals(31, it.popWithDate.peekData())
        }
    }

    @Test
    fun `OnClickConfirm, When isLastDay is false, Set popWithDate value to entered value`() {
        viewModel.intent(PaymentDateSelectionEvent.OnEnterPaymentDate("24"))
        PaymentDateSelectionEvent.OnClickConfirm expectState {
            assertEquals(24, it.popWithDate.peekData())
        }
    }
}