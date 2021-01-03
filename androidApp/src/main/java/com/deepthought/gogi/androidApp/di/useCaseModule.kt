package com.deepthought.gogi.androidApp.di

import com.deepthought.bridge.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUserNameUseCase(get()) }

    factory { SetUserNameUseCase(get()) }

    factory { GetPaidExpendituresUseCase(get()) }

    factory { GetScheduledExpendituresUseCase(get()) }

    factory { GetTodayExpendituresUseCase(get()) }

    factory { InsertDefaultExpenditureCategoriesUseCase(get()) }
}