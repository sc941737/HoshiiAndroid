package com.hoshii

import android.app.Application
import com.hoshii.lib.error.di.errorModule
import com.hoshii.lib.network.networkModule
import com.hoshii.lib.ui.di.uiModule
import com.hoshii.di.appModule
import com.hoshii.features.task_list.di.taskListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                uiModule,
                appModule,
                errorModule,
                networkModule,
                taskListModule,
            )
        }
    }
}