package com.w1nkkkk.effectivemobile

import android.app.Application
import androidx.fragment.app.Fragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(listOf(viewModelModule, favouritesModule, vacanciesModule))
        }
    }
}