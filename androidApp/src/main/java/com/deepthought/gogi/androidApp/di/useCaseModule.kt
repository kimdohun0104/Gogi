package com.deepthought.gogi.androidApp.di

import com.deepthought.bridge.*
import org.koin.dsl.module

val useCaseModule = module {
    /**
     * User name
     */
    factory { GetUserNameUseCase(get()) }

    factory { SetUserNameUseCase(get()) }

    /**
     * Expenditure
     */
    factory { GetPaidExpendituresUseCase(get()) }

    factory { GetScheduledExpendituresUseCase(get()) }

    factory { GetTodayExpendituresUseCase(get()) }

    factory { InsertExpenditureUseCase(get()) }

    /**
     * Expenditure category
     */
    factory { InsertDefaultExpenditureCategoriesUseCase(get()) }

    factory { InsertExpenditureCategoryUseCase(get()) }

    factory { GetExpenditureCategoriesUseCase(get()) }
}