package com.example.newsapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapplicationcompose.presentation.breakingnews.BreakingNewsScreen
import com.example.newsapplicationcompose.viewmodel.NewsViewModel

@Composable
fun NewsNavGraph(
    navHostController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = BottomNavigationScreens.BreakingNewsScreen.route) {
            BreakingNewsScreen(viewModel)
        }
        composable(route = BottomNavigationScreens.GlobalNewsScreen.route) {
            GlobalNewsScreen(viewModel)
        }
        composable(route = BottomNavigationScreens.SearchScreen.route) {
            SearchScreenRoute(viewModel)
        }
        composable(route = BottomNavigationScreens.BookMarksScreen.route) {
            BookMarksScreen(viewModel)
        }
    }
}