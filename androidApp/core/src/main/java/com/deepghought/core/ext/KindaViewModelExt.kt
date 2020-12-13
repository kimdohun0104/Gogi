package com.deepghought.core.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaState

@Composable
fun <S : KindaState> KindaViewModel<S, *, *>.state(): S {
    return this.stateLiveData.observeAsState().value
        ?: throw IllegalStateException()
}

@Composable
fun <S : KindaState> KindaViewModel<S, *, *>.event(
    onEvent: @Composable S.(S) -> Unit
) {
    val state = state()
    onEvent(state, state)
}