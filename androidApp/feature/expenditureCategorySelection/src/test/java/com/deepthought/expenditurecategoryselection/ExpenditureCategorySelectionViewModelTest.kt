package com.deepthought.expenditurecategoryselection

import com.deepthought.bridge.GetExpenditureCategoriesUseCase
import com.deepthought.bridge.model.ExpenditureCategory
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

class ExpenditureCategorySelectionViewModelTest :
    KindaViewModelTest<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>() {

    @Mock
    private lateinit var getExpenditureCategoriesUseCase: GetExpenditureCategoriesUseCase

    override fun buildViewModel(): KindaViewModel<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect> {
        return ExpenditureCategorySelectionViewModel(getExpenditureCategoriesUseCase)
    }

    @Test
    fun `AttemptGetExpenditureCategories, Get expenditure categories using use case, Set expenditureCategories state`(): Unit =
        runBlocking {
            `when`(getExpenditureCategoriesUseCase.invoke(false)).thenReturn(expenditureCategories)

            ExpenditureCategorySelectionEvent.AttemptGetExpenditureCategories expectState {
                assertEquals(expenditureCategories, it.expenditureCategories)
            }

            verify(getExpenditureCategoriesUseCase, atLeast(2)).invoke(false)
        }

    @Test
    fun `OnClickEdit, Set isEdit state to true`() {
        ExpenditureCategorySelectionEvent.OnClickEdit expectState {
            assertTrue(it.isEdit)
        }
    }

    @Test
    fun `OnClickEditComplete, Set isEdit state to false`() {
        ExpenditureCategorySelectionEvent.OnClickEditComplete expectState {
            assertFalse(it.isEdit)
        }
    }

    companion object {
        private val expenditureCategories = listOf(
            ExpenditureCategory(id = 0, name = "Category1"),
            ExpenditureCategory(id = 1, name = "Category2"),
            ExpenditureCategory(id = 2, name = "Category2")
        )
    }
}