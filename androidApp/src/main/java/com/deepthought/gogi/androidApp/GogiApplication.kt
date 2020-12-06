package com.deepthought.gogi.androidApp

import android.app.Application
import com.deepthought.gogi.androidApp.di.preferenceModule
import com.deepthought.gogi.androidApp.di.viewModelModule
import dohun.kim.kinda.kinda_core.logging.KindaLoggerSetting
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class GogiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GogiApplication)
            modules(
                viewModelModule,
                preferenceModule
            )
        }

        if (BuildConfig.DEBUG) {
            KindaLoggerSetting.enableLogging()
            Timber.plant(Timber.DebugTree())
        } else {
            KindaLoggerSetting.disableLogging()
        }
    }
}