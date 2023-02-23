package com.hoshii.features.entry_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoshii.lib.local_db.EntryRepository
import com.hoshii.lib.local_db.models.Entry
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class EntryListViewModel(
    private val entryRepository: EntryRepository,
) : ViewModel() {
    val entries: StateFlow<List<Entry>> = entryRepository.entries
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insertNew() = entryRepository.addGoal()
    fun remove(id: Long) = entryRepository.remove(id)
}