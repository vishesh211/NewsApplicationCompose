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

sealed class BottomNavigationScreens(val route: String, @StringRes val title: Int, val icon: Int) {
    object BreakingNewsScreen: BottomNavigationScreens("main/local", R.string.breaking_news, R.drawable.baseline_library_books_24)
    object BookMarksScreen: BottomNavigationScreens("main/global", R.string.breaking_news, R.drawable.baseline_language_24)
    object SearchScreen: BottomNavigationScreens("main/search", R.string.breaking_news, R.drawable.baseline_search_24)
}
