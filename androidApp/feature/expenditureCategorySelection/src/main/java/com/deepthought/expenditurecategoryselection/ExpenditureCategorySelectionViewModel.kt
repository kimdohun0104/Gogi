package com.deepthought.expenditurecategoryselection

import com.deepthought.bridge.GetExpenditureCategoriesUseCase
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.KindaReducer
import dohun.kim.kinda.kinda_core.KindaSideEffectHandler
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler

class ExpenditureCategorySelectionViewModel(
    private val getExpenditureCategories: GetExpenditureCategoriesUseCase
) : KindaViewModel<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>(
    initialState = ExpenditureCategorySelectionState()
) {
    init {
        intent(ExpenditureCategorySelectionEvent.AttemptGetExpenditureCategories)
    }

    override val reducer: KindaReducer<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>
        get() = buildReducer {
            whenEvent<ExpenditureCategorySelectionEvent.AttemptGetExpenditureCategories> {
                dispatch(ExpenditureCategorySelectionSideEffect.GetExpenditureCategories)
            }

            whenEvent<ExpenditureCategorySelectionEvent.SetExpenditureCategories> {
                next(copy(expenditureCategories = it.expenditureCategories))
            }

            whenEvent<ExpenditureCategorySelectionEvent.OnClickEdit> {
                next(copy(isEdit = true))
            }

            whenEvent<ExpenditureCategorySelectionEvent.OnClickEditComplete> {
                next(copy(isEdit = false))
            }
        }
    override val sideEffectHandler: KindaSideEffectHandler<ExpenditureCategorySelectionState, ExpenditureCategorySelectionEvent, ExpenditureCategorySelectionSideEffect>
        get() = buildSideEffectHandler {
            whenSideEffect<ExpenditureCategorySelectionSideEffect.GetExpenditureCategories> {
                val expenditureCategories = getExpenditureCategories()
                ExpenditureCategorySelectionEvent.SetExpenditureCategories(expenditureCategories)
            }
        }
}