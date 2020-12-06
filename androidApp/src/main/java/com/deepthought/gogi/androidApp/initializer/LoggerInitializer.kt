package com.deepthought.gogi.androidApp.initializer

import android.content.Context
import androidx.startup.Initializer
import com.deepthought.gogi.androidApp.BuildConfig
import dohun.kim.kinda.kinda_core.logging.KindaLoggerSetting
import timber.log.Timber

class LoggerInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            KindaLoggerSetting.enableLogging()
            Timber.plant(Timber.DebugTree())
        } else {
            KindaLoggerSetting.disableLogging()
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}