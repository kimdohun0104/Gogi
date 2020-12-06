package com.deepthought.gogi.androidApp

import com.deepthought.gogi.androidApp.ui.splash.SplashEvent
import com.deepthought.gogi.androidApp.ui.splash.SplashSideEffect
import com.deepthought.gogi.androidApp.ui.splash.SplashState
import com.deepthought.gogi.androidApp.ui.splash.SplashViewModel
import com.deepthought.gogi.preference.PREF_USER_NAME
import com.deepthought.gogi.preference.PreferenceStorage
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

class SplashViewModelTest : KindaViewModelTest<SplashState, SplashEvent, SplashSideEffect>() {

    @Mock
    private lateinit var preferenceStorage: PreferenceStorage

    override fun buildViewModel(): KindaViewModel<SplashState, SplashEvent, SplashSideEffect> {
        return SplashViewModel(preferenceStorage)
    }

    @Test
    fun `AttemptGetUserNameAndDelay, Event invoked with delay 1300, get userName after 1300 milliseconds`() {
        SplashEvent.AttemptGetUserNameAndDelay(1300) expectState {
            verifyNoInteractions(preferenceStorage)
        }

        Thread.sleep(1300)

        expectState {
            verify(preferenceStorage, atMost(2)).getString(PREF_USER_NAME)
        }
    }

    @Test
    fun `NavigateHome, Event invoked, NavigateHome state is not null`() {
        SplashEvent.NavigateHome expectState {
            assertNotNull(it.navigateHome.peekData())
        }
    }

    @Test
    fun `NavigateInputName, Event invoked, NavigateInputName state is not null`() {
        SplashEvent.NavigateInputName expectState {
            assertNotNull(it.navigateInputName.peekData())
        }
    }

    @Test
    fun `AttemptGetUserNameAndDelay, UserName is not null in storage, NavigateHome state is not null`() {
        `when`(preferenceStorage.getString(PREF_USER_NAME))
            .thenReturn("Hello")

        SplashEvent.AttemptGetUserNameAndDelay(0L) expectState {
            assertNotNull(it.navigateHome.peekData())
        }
    }

    @Test
    fun `AttemptGetUserNameAndDelay, UserName is null in storage, NavigateInputName state is not null`() {
        `when`(preferenceStorage.getString(PREF_USER_NAME))
            .thenReturn(null)

        SplashEvent.AttemptGetUserNameAndDelay(0L) expectState {
            assertNotNull(it.navigateInputName.peekData())
        }
    }
}