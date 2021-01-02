package com.deepthought.home

import com.deepthought.bridge.GetPaidExpendituresUseCase
import com.deepthought.bridge.GetScheduledExpenditureUseCase
import com.deepthought.bridge.GetTodayExpendituresUseCase
import com.deepthought.bridge.GetUserNameUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class HomeViewModel(
    private val getUserName: GetUserNameUseCase,
    private val getPaidExpenditures: GetPaidExpendituresUseCase,
    private val getScheduledExpenditures: GetScheduledExpenditureUseCase,
    private val getTodayExpenditures: GetTodayExpendituresUseCase
) : KindaViewModel<HomeState, HomeEvent, HomeSideEffect>(
    initialState = HomeState()
) {

    override val reducer: KindaReducer<HomeState, HomeEvent, HomeSideEffect>
        get() = buildReducer { }

    override val sideEffectHandler: KindaSideEffectHandler<HomeState, HomeEvent, HomeSideEffect>
        get() = buildSideEffectHandler { }
}