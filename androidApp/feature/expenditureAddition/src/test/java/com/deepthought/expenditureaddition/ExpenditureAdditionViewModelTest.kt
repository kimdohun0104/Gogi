package com.deepthought.expenditureaddition

import com.deepthought.bridge.InsertExpenditureUseCase
import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.PaymentDate
import com.deepthought.core.ext.anyNotNull
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

class ExpenditureAdditionViewModelTest :
    KindaViewModelTest<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect>() {

    @Mock
    private lateinit var insertExpenditureUseCase: InsertExpenditureUseCase

    override fun buildViewModel(): KindaViewModel<ExpenditureAdditionState, ExpenditureAdditionEvent, ExpenditureAdditionSideEffect> {
        return ExpenditureAdditionViewModel(insertExpenditureUseCase)
    }

    @Test
    fun `OnSelectExpenditureCategory, Set expenditureCategory to selected`() {
        ExpenditureAdditionEvent.OnSelectExpenditureCategory(expenditureCategory) expectState {
            assertEquals(expenditureCategory, it.expenditureCategory)
        }
    }

    @Test
    fun `OnSelectPaymentDate, Set paymentDate to selected`() {
        ExpenditureAdditionEvent.OnSelectPaymentDate(paymentDate) expectState {
            assertEquals(paymentDate, it.paymentDate)
        }
    }

    @Test
    fun `OnEnterName, Set name to entered`() {
        ExpenditureAdditionEvent.OnEnterName("name") expectState {
            assertEquals("name", it.name)
        }
    }

    @Test
    fun `OnEnterPrice, Set price to entered`() {
        ExpenditureAdditionEvent.OnEnterPrice("1000") expectState {
            assertEquals("1000", it.price)
        }
    }

    @Test
    fun `OnConfirm, Execute popBackStack event`() {
        ExpenditureAdditionEvent.OnConfirm expectState {
            assertNotNull(it.popBackStack.peekData())
        }
    }

    @Test
    fun `AttemptInsertExpenditure, When current paymentDate is null, No interaction on insertExpenditure`() {
        ExpenditureAdditionEvent.AttemptInsertExpenditure expectState {
            verifyNoMoreInteractions(insertExpenditureUseCase)
        }
    }

    @Test
    fun `AttemptInsertExpenditure, When every input field filled, Invoke insertExpenditure`() =
        runBlocking {
            `when`(insertExpenditureUseCase.invoke(anyNotNull())).thenReturn(Unit)

            listOf(
                ExpenditureAdditionEvent.OnSelectPaymentDate(PaymentDate(0, true)),
                ExpenditureAdditionEvent.OnSelectExpenditureCategory(
                    ExpenditureCategory(0, "name")
                ),
                ExpenditureAdditionEvent.AttemptInsertExpenditure
            ) expectState {
                assertNotNull(it.popBackStack)
            }

            verify(insertExpenditureUseCase).invoke(anyNotNull())
        }

    companion object {
        private val expenditureCategory = ExpenditureCategory(0, "name")
        private val paymentDate = PaymentDate(13, false)
    }
}