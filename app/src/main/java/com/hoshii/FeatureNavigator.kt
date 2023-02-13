package com.hoshii

import androidx.navigation.NavController
import com.hoshii.features.entry_list.ui.EntryListNavigator
import com.ramcosta.composedestinations.spec.DestinationSpec

class FeatureNavigator(
    private val currentDestination: DestinationSpec<*>,
    private val navController: NavController,
) : EntryListNavigator {

}