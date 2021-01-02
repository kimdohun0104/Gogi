package com.deepthought.home

import com.deepthought.bridge.*
import com.deepthought.bridge.model.Expenditure
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler
import kotlinx.coroutines.*

class HomeViewModel(
    private val getUserName: GetUserNameUseCase,
    private val getPaidExpenditures: GetPaidExpendituresUseCase,
    private val getScheduledExpenditures: GetScheduledExpendituresUseCase,
    private val getTodayExpenditures: GetTodayExpendituresUseCase
) : KindaViewModel<HomeState, HomeEvent, HomeSideEffect>(
    initialState = HomeState()
) {

    init {
        intent(HomeEvent.AttemptGetExpenditures)
        intent(HomeEvent.SetUserName)
    }

    override val reducer: KindaReducer<HomeState, HomeEvent, HomeSideEffect>
        get() = buildReducer {
            whenEvent<HomeEvent.AttemptGetExpenditures> {
                dispatch(HomeSideEffect.GetExpenditures)
            }

            whenEvent<HomeEvent.SetExpenditures> {
                next(
                    copy(
                        todayExpenditures = it.today,
                        paidExpenditures = it.paid,
                        scheduledExpenditures = it.scheduled,
                        totalExpenditure = it.totalExpenditure,
                        hasExpenditure = it.hasExpenditure
                    )
                )
            }

            whenEvent<HomeEvent.SetUserName> {
                val name = getUserName()
                if (name.isNullOrBlank()) {
                    next(copy(navigateInputName = Event(Unit)))
                } else {
                    next(copy(userName = name))
                }
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<HomeState, HomeEvent, HomeSideEffect>
        get() = buildSideEffectHandler {
            whenSideEffect<HomeSideEffect.GetExpenditures> {
                getExpenditures()
            }
        }

    private suspend fun getExpenditures(): HomeEvent {
        return coroutineScope {
            val results = listOf(
                async { getPaidExpenditures() },
                async { getScheduledExpenditures() },
                async { getTodayExpenditures() }
            ).awaitAll()

            HomeEvent.SetExpenditures(
                paid = results[0],
                scheduled = results[1],
                today = results[2],
                totalExpenditure = getTotalPriceFromResults(results),
                hasExpenditure = hasExpenditure(results)
            )
        }
    }

    private suspend fun getTotalPriceFromResults(results: List<List<Expenditure>>): Int =
        withContext(Dispatchers.IO) {
            results.fold(0) { acc: Int, list: List<Expenditure> ->
                acc + list.fold(0) { elementAcc, expenditure ->
                    elementAcc + expenditure.price
                }
            }
        }

    private fun hasExpenditure(results: List<List<Expenditure>>): Boolean {
        return results.none { it.isNullOrEmpty() }
    }
}