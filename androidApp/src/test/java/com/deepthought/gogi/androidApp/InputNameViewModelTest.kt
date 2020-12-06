package com.deepthought.gogi.androidApp

import com.deepthought.gogi.androidApp.ui.inputName.InputNameEvent
import com.deepthought.gogi.androidApp.ui.inputName.InputNameSideEffect
import com.deepthought.gogi.androidApp.ui.inputName.InputNameState
import com.deepthought.gogi.androidApp.ui.inputName.InputNameViewModel
import com.deepthought.gogi.preference.PREF_USER_NAME
import com.deepthought.gogi.preference.PreferenceStorage
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class InputNameViewModelTest :
    KindaViewModelTest<InputNameState, InputNameEvent, InputNameSideEffect>() {

    @Mock
    private lateinit var preferenceStorage: PreferenceStorage

    override fun buildViewModel(): KindaViewModel<InputNameState, InputNameEvent, InputNameSideEffect> {
        return InputNameViewModel(preferenceStorage)
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
    fun `OnClickInputNameComplete, abc entered, Save 'abc' to preference and navigate home`() {
        listOf(
            InputNameEvent.OnEnterName("abc"),
            InputNameEvent.OnClickInputNameComplete
        ) expectState {
            verify(preferenceStorage).setString(PREF_USER_NAME, "abc")

            assertNotNull(it.navigateHome.peekData())
        }
    }
}