package com.hoshii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramcosta.composedestinations.DestinationsNavHost
import com.hoshii.lib.ui_theme.HoshiiTheme
import com.ramcosta.composedestinations.navigation.dependency
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoshiiTheme {
                DestinationsNavHost(
                    navGraph = RootNavGraph,
                    dependenciesContainerBuilder = {
                        dependency(FeatureNavigator(destination, navController))
                    }
                )
            }
        }
//        subscribe(viewModel.taskErrorEvents) { showToast(it.message) }
    }
}