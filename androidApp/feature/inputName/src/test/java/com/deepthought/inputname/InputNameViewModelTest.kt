package com.deepthought.inputname

import com.deepthought.bridge.InsertDefaultExpenditureCategoriesUseCase
import com.deepthought.bridge.SetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class InputNameViewModelTest :
    KindaViewModelTest<InputNameState, InputNameEvent, InputNameSideEffect>() {

    @Mock
    private lateinit var setUserNameUseCase: SetUserNameUseCase

    @Mock
    private lateinit var insertDefaultExpenditureCategoriesUseCase: InsertDefaultExpenditureCategoriesUseCase

    override fun buildViewModel(): KindaViewModel<InputNameState, InputNameEvent, InputNameSideEffect> {
        return InputNameViewModel(setUserNameUseCase, insertDefaultExpenditureCategoriesUseCase)
    }

    @Test
    fun `OnEnterName, abc entered, isNextBtnEnabled is true`() {
        InputNameEvent.OnEnterName("abc") expectState {
            assertEquals("abc", it.name)
            assertTrue(it.isNextBtnEnabled)
        }
    }

    @Test
    fun `OnEnterName, blank entered, isNextBtnEnabled is false`() {
        InputNameEvent.OnEnterName("") expectState {
            assertEquals("", it.name)
            assertFalse(it.isNextBtnEnabled)
        }
    }

    @Test
    fun `OnClickInputNameComplete, abc entered, Save 'abc' to preference and navigate home`(): Unit =
        runBlocking {
            listOf(
                InputNameEvent.OnEnterName("abc"),
                InputNameEvent.OnClickInputNameComplete
            ) expectState {
                assertNotNull(it.navigateHome.peekData())
            }
            verify(setUserNameUseCase).invoke("abc")
            verify(insertDefaultExpenditureCategoriesUseCase).invoke()
        }
}