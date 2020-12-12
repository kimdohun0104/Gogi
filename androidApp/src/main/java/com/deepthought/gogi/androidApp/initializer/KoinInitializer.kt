package com.deepthought.gogi.androidApp.initializer

import android.content.Context
import androidx.startup.Initializer
import com.deepthought.gogi.androidApp.di.preferenceModule
import com.deepthought.gogi.androidApp.di.useCaseModule
import com.deepthought.gogi.androidApp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        startKoin {
            androidContext(context)
            modules(
                viewModelModule,
                preferenceModule,
                useCaseModule
            )
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}