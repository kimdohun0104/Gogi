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

    /**
     * Expenditure category
     */
    factory { InsertDefaultExpenditureCategoriesUseCase(get()) }

    factory { GetExpenditureCategoriesUseCase(get()) }
}