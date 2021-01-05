package com.deepthought.expenditurecategoryaddition

import com.deepthought.bridge.InsertExpenditureCategoryUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class ExpenditureCategoryAdditionViewModelTest :
    KindaViewModelTest<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>() {

    @Mock
    private lateinit var insertExpenditureCategoryUseCase: InsertExpenditureCategoryUseCase

    override fun buildViewModel(): KindaViewModel<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect> {
        return ExpenditureCategoryAdditionViewModel(insertExpenditureCategoryUseCase)
    }

    @Test
    fun `OnEnterCategoryName, Enter abc, Set categoryName to abc`() {
        ExpenditureCategoryAdditionEvent.OnEnterCategoryName("abc") expectState {
            assertEquals("abc", it.categoryName)
        }
    }

    @Test
    fun `OnClickAddCategory, Invoke insert expenditure category and popBackStack`(): Unit =
        runBlocking {
            val categoryName = "categoryName"

            viewModel.intent(ExpenditureCategoryAdditionEvent.OnEnterCategoryName("categoryName"))
            ExpenditureCategoryAdditionEvent.OnClickAddCategory expectState {
                assertNotNull(it.popBackStack.peekData())
            }

            verify(insertExpenditureCategoryUseCase).invoke(categoryName)
        }

    @Test
    fun `PopBackStack, popBackStack event`() {
        ExpenditureCategoryAdditionEvent.PopBackStack expectState {
            assertNotNull(it.popBackStack.peekData())
        }
    }
}