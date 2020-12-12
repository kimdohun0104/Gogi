package com.deepthought.home

import com.deepthought.bridge.GetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class HomeViewModel(
    private val getUserNameUseCase: GetUserNameUseCase
) : KindaViewModel<HomeState, HomeEvent, HomeSideEffect>(
    initialState = HomeState(),
    reducer = buildReducer { },
    sideEffectHandler = buildSideEffectHandler { }
)