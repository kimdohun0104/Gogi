package com.deepthought.splash

import com.deepthought.bridge.GetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler
import kotlinx.coroutines.delay

class SplashViewModel(
    private val getUserNameUseCase: GetUserNameUseCase
) : KindaViewModel<SplashState, SplashEvent, SplashSideEffect>(
    initialState = SplashState()
) {

    init {
        intent(SplashEvent.AttemptGetUserNameAndDelay(1300L))
    }

    override val reducer: KindaReducer<SplashState, SplashEvent, SplashSideEffect>
        get() = buildReducer {
            whenEvent<SplashEvent.AttemptGetUserNameAndDelay> {
                dispatch(SplashSideEffect.GetUserNameAndDelay(delay = it.delay))
            }

            whenEvent<SplashEvent.NavigateHome> {
                next(copy(navigateHome = Event(Unit)))
            }

            whenEvent<SplashEvent.NavigateInputName> {
                next(copy(navigateInputName = Event(Unit)))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<SplashState, SplashEvent, SplashSideEffect>
        get() = buildSideEffectHandler {
            whenSideEffect<SplashSideEffect.GetUserNameAndDelay> {
                delay(it.delay)

                val userName = getUserNameUseCase()
                if (userName.isNullOrBlank()) {
                    SplashEvent.NavigateInputName
                } else {
                    SplashEvent.NavigateHome
                }

            }
        }
}