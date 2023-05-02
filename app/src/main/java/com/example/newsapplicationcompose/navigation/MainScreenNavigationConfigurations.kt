package com.example.newsapplicationcompose.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newsapplicationcompose.presentation.components.NewsScaffold
import com.example.newsapplicationcompose.presentation.rememberNewsAppState
import com.example.newsapplicationcompose.ui.theme.NewsApplicationComposeTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenNavigationConfigurations() {
    NewsApplicationComposeTheme {
        val appState = rememberNewsAppState()
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
            }
        ) { innerPaddingModifier ->
            NewsNavGraph(
                modifier = Modifier.padding(innerPaddingModifier),
                navHostController = appState.navController,
                startDestination = BottomNavigationScreens.BreakingNewsScreen.route
            )
        }
    }
}

@Composable
fun NewsBottomBar(
    tabs: List<BottomNavigationScreens>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.primary
) {
    NavigationBar {
        tabs.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navigateToRoute },
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = null) },
                label = { Text(text = stringResource(id = screen.title))},
                alwaysShowLabel = false
            )
        }
    }
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
private val bottomNavigationItems = listOf(
    BottomNavigationScreens.BookMarksScreen,
    BottomNavigationScreens.SearchScreen,
    BottomNavigationScreens.BreakingNewsScreen
)

object MainDestinations {
    const val HOME_ROUTE = "home"
}
