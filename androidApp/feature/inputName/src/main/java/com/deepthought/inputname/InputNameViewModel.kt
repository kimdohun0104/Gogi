package com.deepthought.inputname

import com.deepthought.bridge.SetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class InputNameViewModel(
    private val setUsernameUseCase: SetUserNameUseCase
) : KindaViewModel<InputNameState, InputNameEvent, InputNameSideEffect>(
    initialState = InputNameState(),
    reducer = buildReducer {
        whenEvent<InputNameEvent.OnEnterName> {
            next(copy(name = it.name, isNextBtnEnabled = it.name.isNotBlank()))
        }

        whenEvent<InputNameEvent.OnClickInputNameComplete> {
            setUsernameUseCase(name)
            next(copy(navigateHome = Event(Unit)))
        }
    },
    sideEffectHandler = buildSideEffectHandler {
    }
)