package com.example.newsapplicationcompose.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.newsapplicationcompose.presentation.components.NewsScaffold
import com.example.newsapplicationcompose.presentation.rememberNewsAppState
import com.example.newsapplicationcompose.ui.theme.NewsApplicationComposeTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenNavigationConfigurations() {
    NewsApplicationComposeTheme {
        val appState = rememberNewsAppState()
        val snackbarHostState = remember{ SnackbarHostState() }
        NewsScaffold(
            topBar = {
                NewsTopBar(
                    title = {
                        Text(text = "NewsApp")
                    }
                )
            },
            bottomBar = {
                NewsBottomBar(
                    tabs = bottomNavigationItems,
                    currentRoute = appState.currentRoute!!,
                    navigateToRoute = appState::navigationToBottomBarRoute
                )
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier.systemBarsPadding(),
                    snackbar = { snackbarData ->  NewsSnackBar(snackbarData = snackbarData) }
                )
            }
        ) { innerPaddingModifier ->
            NavHost(
                navController = appState.navController,
                startDestination = BottomNavigationScreens.BreakingNewsScreen.route,
                modifier = Modifier.padding(innerPaddingModifier)
            ) {
                newsNavGraph(
                    onNewsSelected = appState::na
                )
            }
        }
    }
}

private fun NavGraphBuilder.newsNavGraph(
    onNewsSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = BottomNavigationScreens.BreakingNewsScreen.route
    ) {

    }
}

@Composable
fun NewsBottomBar(
    tabs: Array<BottomNavigationScreens>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.primary
) {

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

fun lerp(start: Int, stop: Int, fraction: Float): Int {
    return start + ((stop - start) * fraction.toDouble()).roundToInt()
}

private val BottomNavIndicatorShape: Shape = RoundedCornerShape(50)
private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
private val bottomNavigationItems = arrayOf(
    BottomNavigationScreens.BookMarksScreen,
    BottomNavigationScreens.SearchScreen,
    BottomNavigationScreens.BreakingNewsScreen
)

object MainDestinations {
    const val HOME_ROUTE = "home"
}
