package com.deepthought.gogi.androidApp.di

import com.deepthought.bridge.GetUserNameUseCase
import com.deepthought.bridge.SetUserNameUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUserNameUseCase(get()) }

    factory { SetUserNameUseCase(get()) }
}