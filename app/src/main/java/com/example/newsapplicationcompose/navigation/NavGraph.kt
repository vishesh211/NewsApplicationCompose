package com.example.newsapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

@Composable
fun NavGraphBuilder.NavGraph(
    onNewsSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(BottomNavigationScreens.BreakingNewsScreen.route) {

    }
}