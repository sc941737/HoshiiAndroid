package com.hoshii.lib.ui.di

import com.hoshii.lib.ui.ResourceProvider
import com.hoshii.lib.ui.ResourceProviderImpl
import org.koin.dsl.module

val uiModule = module {
    single<ResourceProvider> {
        ResourceProviderImpl(get())
    }
}