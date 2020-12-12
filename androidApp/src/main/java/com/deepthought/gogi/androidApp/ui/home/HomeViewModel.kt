package com.deepthought.gogi.androidApp.ui.home

import com.deepthought.gogi.preference.PreferenceStorage
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class HomeViewModel(
    private val preferenceStorage: PreferenceStorage
) : KindaViewModel<HomeState, HomeEvent, HomeSideEffect>(
    initialState = HomeState(),
    reducer = buildReducer { },
    sideEffectHandler = buildSideEffectHandler { }
)