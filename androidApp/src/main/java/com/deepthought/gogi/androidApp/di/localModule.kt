package com.deepthought.gogi.androidApp.di

import androidx.room.Room
import com.deepthought.local.AppDatabase
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "gogi.db").build()
    }

    single { get<AppDatabase>().expenditureDao() }
}