package com.hoshii.features.task_list.di

import org.koin.dsl.module

val taskListUiModule = module {
    // viewModel { }
}

val taskListModule = module {
    includes(
        taskListUiModule,
    )
}