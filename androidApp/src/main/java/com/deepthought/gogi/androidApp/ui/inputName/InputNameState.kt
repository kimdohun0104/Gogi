package com.deepthought.gogi.androidApp.ui.inputName

import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class InputNameState(
    val name: String = "",

    val isNextBtnEnabled: Boolean = false,

    val navigateHome: Event<Unit> = Event(),
) : KindaState

sealed class InputNameEvent : KindaEvent {
    data class OnEnterName(val name: String) : InputNameEvent()

    object OnClickInputNameComplete : InputNameEvent()
}

sealed class InputNameSideEffect : KindaSideEffect {
}