package com.deepthought.expenditurecategoryaddition

import com.deepthought.bridge.InsertExpenditureCategoryUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureCategoryAdditionViewModel(
    private val insertExpenditureCategory: InsertExpenditureCategoryUseCase
) : KindaViewModel<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>(
    initialState = ExpenditureCategoryAdditionState()
) {
    override val reducer: KindaReducer<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>
        get() = buildReducer {
            whenEvent<ExpenditureCategoryAdditionEvent.OnClickAddCategory> {
                dispatch(
                    ExpenditureCategoryAdditionSideEffect.InsertExpenditureCategory(categoryName)
                )
            }

            whenEvent<ExpenditureCategoryAdditionEvent.OnEnterCategoryName> {
                next(
                    copy(
                        categoryName = it.categoryName,
                        isCompleteEnable = it.categoryName.isNotBlank()
                    )
                )
            }

            whenEvent<ExpenditureCategoryAdditionEvent.PopBackStack> {
                next(copy(popBackStack = Event(Unit)))
            }
        }

    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureCategoryAdditionState, ExpenditureCategoryAdditionEvent, ExpenditureCategoryAdditionSideEffect>
        get() = buildSideEffectHandler {
            whenSideEffect<ExpenditureCategoryAdditionSideEffect.InsertExpenditureCategory> {
                insertExpenditureCategory(it.categoryName)
                ExpenditureCategoryAdditionEvent.PopBackStack
            }
        }
}