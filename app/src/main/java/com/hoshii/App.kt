package com.hoshii

import android.app.Application
import com.hoshii.lib.error.di.errorModule
import com.hoshii.lib.network.networkModule
import com.hoshii.lib.ui.di.uiModule
import com.hoshii.di.appModule
import com.hoshii.features.entry_list.di.entryListModule
import com.hoshii.lib.local_db.di.localDbModule
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
                localDbModule,
                entryListModule,
            )
        }
    }
}