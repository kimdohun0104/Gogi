package com.deepthought.splash

import com.deepthought.bridge.GetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

class SplashViewModelTest : KindaViewModelTest<SplashState, SplashEvent, SplashSideEffect>() {

    @Mock
    private lateinit var getUserNameUseCase: GetUserNameUseCase

    override fun buildViewModel(): KindaViewModel<SplashState, SplashEvent, SplashSideEffect> {
        return SplashViewModel(getUserNameUseCase)
    }

    @Test
    fun `AttemptGetUserNameAndDelay, Event invoked with delay 1300, get userName after 1300 milliseconds`() {
        SplashEvent.AttemptGetUserNameAndDelay(1300) expectState {
            verifyNoInteractions(getUserNameUseCase)
        }

        Thread.sleep(1300)

        expectState {
            verify(getUserNameUseCase, atMost(2)).invoke()
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
        `when`(getUserNameUseCase.invoke()).thenReturn("Hello")

        SplashEvent.AttemptGetUserNameAndDelay(0L) expectState {
            assertNotNull(it.navigateHome.peekData())
        }
    }

    @Test
    fun `AttemptGetUserNameAndDelay, UserName is null in storage, NavigateInputName state is not null`() {
        `when`(getUserNameUseCase.invoke()).thenReturn(null)

        SplashEvent.AttemptGetUserNameAndDelay(0L) expectState {
            assertNotNull(it.navigateInputName.peekData())
        }
    }
}