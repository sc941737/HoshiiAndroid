package com.hoshii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import com.hoshii.features.task_list.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.hoshii.lib.ui.showToast
import com.hoshii.lib.ui.subscribe
import com.hoshii.lib.ui_theme.HoshiiTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoshiiTheme {
//                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
//        subscribe(viewModel.taskErrorEvents) { showToast(it.message) }
    }
}