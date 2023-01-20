package com.hoshii.lib.error.di

import com.hoshii.lib.error.ErrorTracker
import com.hoshii.lib.error.ErrorTrackerImpl
import org.koin.dsl.module

val errorModule = module {
    single<ErrorTracker> {
        ErrorTrackerImpl(get())
    }
}