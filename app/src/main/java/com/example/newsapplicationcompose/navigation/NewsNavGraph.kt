package com.example.newsapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NewsNavGraph(
    navHostController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = BottomNavigationScreens.BreakingNewsScreen.route) {
            BreakingNewsScreen()
        }
        composable(route = BottomNavigationScreens.GlobalNewsScreen.route) {
            GlobalNewsScreen()
        }
        composable(route = BottomNavigationScreens.SearchScreen.route) {
            SearchScreenRoute()
        }
        composable(route = BottomNavigationScreens.BookMarksScreen.route) {
            BookMarksScreen()
        }
    }
}