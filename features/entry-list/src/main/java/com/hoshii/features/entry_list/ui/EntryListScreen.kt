package com.hoshii.features.entry_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import org.koin.androidx.compose.koinViewModel

interface EntryListNavigator

@Destination
@RootNavGraph(start = true)
@Composable
fun EntryListScreen(
    viewModel: EntryListViewModel = koinViewModel()
) {
    val entries by viewModel.entries.collectAsState()
    Column {
        Button(onClick = {
            viewModel.insertNew()
        }) {
            Text("Add")
        }
        LazyColumn(content = {
            items(items = entries, key = { it.id }) {
                Text(text = it.toString(), modifier = Modifier.clickable(
                    enabled = true,
                    onClick = {
                        viewModel.remove(it.id)
                    }
                ))
            }
        })
    }
}