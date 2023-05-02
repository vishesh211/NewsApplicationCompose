package com.example.newsapplicationcompose.navigation

import android.graphics.drawable.VectorDrawable
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.newsapplicationcompose.R

sealed class BottomNavigationScreens(val route: String, @StringRes val title: Int, val icon: Int, val order: Int) {
    object BreakingNewsScreen: BottomNavigationScreens("main/local", R.string.breaking_news, R.drawable.baseline_library_books_24, 0)
    object GlobalNewsScreen: BottomNavigationScreens("main/global", R.string.global_news, R.drawable.baseline_language_24, 1)
    object SearchScreen: BottomNavigationScreens("main/search", R.string.search_screen, R.drawable.baseline_search_24, 2)
    object BookMarksScreen: BottomNavigationScreens("main/bookmarks", R.string.bookmarks_screen, R.drawable.baseline_bookmarks_24, 2)
}
