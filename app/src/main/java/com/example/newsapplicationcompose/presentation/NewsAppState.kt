package com.example.newsapplicationcompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberNewsAppState(
    navController: NavHostController = rememberNavController()
) =
    remember(navController) {
        NewsAppState(navController)
    }


@Stable
class NewsAppState(val navController: NavHostController) {

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigationToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true

                popUpTo(findStartDestination(navController.graph).id)
            }
        }
    }

    private fun NavBackStackEntry.lifecycleResumed() =
        this.getLifecycle().currentState == Lifecycle.State.RESUMED

    private val NavGraph.startDestination: NavDestination?
        get() = findNode(startDestinationId)

    private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
        return if (graph is NavGraph) findStartDestination(graph.findStartDestination()!!) else graph
    }
}
