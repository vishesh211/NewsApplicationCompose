package com.example.newsapplicationcompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberNewsAppState(
    navController: NavController = rememberNavController()
) =
    remember(navController) {
        NewsAppState(navController)
    }


@Stable
class NewsAppState(val navController: NavController) {

    val currentRoute: String?
        get() = navController.currentDestination?.route
}
