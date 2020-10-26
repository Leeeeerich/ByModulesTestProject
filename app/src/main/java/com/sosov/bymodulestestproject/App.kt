package com.sosov.bymodulestestproject

import android.app.Application
import com.sosov.bymodulestestproject.di.DependencyInjector
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(DependencyInjector.appModule))
    }
}
