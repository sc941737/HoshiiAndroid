package com.hoshii.features.entry_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoshii.lib.local_db.EntryRepository
import com.hoshii.lib.local_db.models.Entry
import com.hoshii.lib.local_db.models.SimpleGoal
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class EntryListViewModel(
    private val entryRepository: EntryRepository,
) : ViewModel() {
    val entries: StateFlow<List<Entry>> = entryRepository.entries
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insertNew() = entryRepository.addSimpleGoal(
        SimpleGoal(
            title = "quack",
            description = null,
            calculateProgressFromChildren = false,
            progress = 0,
            priority = 0,
            childrenIds = emptyList(),
            parents = emptyList(),
            dateCreated = 0,
            dateFinished = 0,
            dateOfStart = 0,
            dateOfFinish = 0,
        )
    )
    fun remove(id: Long) = entryRepository.remove(id)
}