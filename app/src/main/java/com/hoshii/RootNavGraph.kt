package com.hoshii

import com.hoshii.features.entry_list.ui.EntrylistNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph : NavGraphSpec {
    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
    override val route = "root"
    override val startRoute: Route = EntrylistNavGraph
    override val nestedNavGraphs = listOf(
        EntrylistNavGraph
    )
}