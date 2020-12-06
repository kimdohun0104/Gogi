package com.deepthought.gogi.androidApp.ui.home

import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class HomeViewModel : KindaViewModel<HomeState, HomeEvent, HomeSideEffect>(
    initialState = HomeState(),
    reducer = buildReducer { },
    sideEffectHandler = buildSideEffectHandler { }
)