package com.deepthought.gogi.androidApp.di

import com.deepthought.gogi.preference.PreferenceStorage
import com.deepthought.gogi.preference.PreferenceStorageImpl
import org.koin.dsl.module

val preferenceModule = module {

    single<PreferenceStorage> { PreferenceStorageImpl(get()) }
}