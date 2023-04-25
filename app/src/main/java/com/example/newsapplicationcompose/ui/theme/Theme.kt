package com.example.newsapplicationcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = NewsComposeColors(
    primary = Violet500,
    primaryContainer = Violet700,
    secondary = White,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val LightColorPalette = NewsComposeColors(
    primary = Violet500,
    primaryContainer = Violet700,
    secondary = White,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun NewsApplicationComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvidesNewsApplicationComposeTheme(colors) {
        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

private val LocalNewsComposeColors = staticCompositionLocalOf<NewsComposeColors> {
    error("No NewsComposeColors Provided.")
}

@Composable
fun ProvidesNewsApplicationComposeTheme(
    colors: NewsComposeColors,
    content: @Composable () -> Unit
) {
    val colorsPalette = remember {
        colors.copy()
    }
    colorsPalette.update(colors)
    CompositionLocalProvider(LocalNewsComposeColors provides colorsPalette, content = content)
}

class NewsComposeColors(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    secondary: Color,
    onSecondary: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        private set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        private set
    var primaryContainer by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        private set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        private set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        private set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        private set
    var onBackground by mutableStateOf(onBackground, structuralEqualityPolicy())
        private set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        private set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        private set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        ): NewsComposeColors =
        NewsComposeColors(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            secondary = secondary,
            onSecondary = onSecondary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
        )

    fun update(other: NewsComposeColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        primaryContainer = other.primaryContainer
        secondary = other.secondary
        onSecondary = other.onSecondary
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
    }
}
