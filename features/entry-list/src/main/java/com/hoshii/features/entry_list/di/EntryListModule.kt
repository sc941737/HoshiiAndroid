package com.hoshii.features.entry_list.di

import com.hoshii.features.entry_list.ui.EntryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val entryListUiModule = module {
     viewModel {
         EntryListViewModel(get())
     }
}

val entryListModule = module {
    includes(
        entryListUiModule,
    )
}