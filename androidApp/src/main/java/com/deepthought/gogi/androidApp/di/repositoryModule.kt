package com.deepthought.gogi.androidApp.di

import com.deepthought.repository.ExpenditureCategoryRepository
import com.deepthought.repository.ExpenditureCategoryRepositoryImpl
import com.deepthought.repository.ExpenditureRepository
import com.deepthought.repository.ExpenditureRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<ExpenditureRepository> { ExpenditureRepositoryImpl(get()) }

    single<ExpenditureCategoryRepository> { ExpenditureCategoryRepositoryImpl(get()) }
}