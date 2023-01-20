package com.hoshii.di

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.coroutineScope
import com.hoshii.MainViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CoroutineScope> {
        ProcessLifecycleOwner.get().lifecycle.coroutineScope
    }
    viewModel {
        MainViewModel(get())
    }
}