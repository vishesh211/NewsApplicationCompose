package com.example.newsapplicationcompose.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsapplicationcompose.presentation.components.NewsScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenNavigationConfigurations() {
    NewsScaffold(
        topBar = {
            NewsTopBar(
                title = {
                    Text(text = "NewsApp")
                }
            )
        },
        bottomBar = {

        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}
