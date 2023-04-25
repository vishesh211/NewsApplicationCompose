package com.example.newsapplicationcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Violet500,
    primaryContainer = Violet700,
    secondary = White
)

private val LightColorPalette = lightColorScheme(
    primary = Violet500,
    primaryContainer = Violet700,
    secondary = White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
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
    onPrimaryContainer: Color,
    inversePrimary: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        private set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        private set
    var primaryContainer by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        private set
    var onPrimaryContainer by mutableStateOf(onPrimaryContainer, structuralEqualityPolicy())
        private set
    var inversePrimary by mutableStateOf(inversePrimary, structuralEqualityPolicy())
        private set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        private set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        private set
    var secondaryContainer by mutableStateOf(secondaryContainer, structuralEqualityPolicy())
        private set
    var onSecondaryContainer by mutableStateOf(onSecondaryContainer, structuralEqualityPolicy())
        private set
    var tertiary by mutableStateOf(tertiary, structuralEqualityPolicy())
        private set
    var onTertiary by mutableStateOf(onTertiary, structuralEqualityPolicy())
        private set
    var tertiaryContainer by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        private set
    var onTertiaryContainer by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        private set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        private set
    var onBackground by mutableStateOf(onBackground, structuralEqualityPolicy())
        private set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        private set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        private set
    var surfaceVariant by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        private set
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        private set
    var surfaceTint by mutableStateOf(surfaceTint, structuralEqualityPolicy())
        private set
    var inverseSurface by mutableStateOf(inverseSurface, structuralEqualityPolicy())
        private set
    var inverseOnSurface by mutableStateOf(inverseOnSurface, structuralEqualityPolicy())
        private set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        private set
    var onError by mutableStateOf(onError, structuralEqualityPolicy())
        private set
    var errorContainer by mutableStateOf(errorContainer, structuralEqualityPolicy())
        private set
    var onErrorContainer by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        private set
    var outline by mutableStateOf(outline, structuralEqualityPolicy())
        private set
    var outlineVariant by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        private set
    var scrim by mutableStateOf(scrim, structuralEqualityPolicy())
        private set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
    ): NewsComposeColors =
        NewsComposeColors(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            inversePrimary = inversePrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            outline = outline,
            outlineVariant = outlineVariant,
            scrim = scrim,
        )

    fun update(other: NewsComposeColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        primaryContainer = other.primaryContainer
        onPrimaryContainer = other.onPrimaryContainer
        inversePrimary = other.inversePrimary
        secondary = other.secondary
        onSecondary = other.onSecondary
        secondaryContainer = other.secondaryContainer
        onSecondaryContainer = other.onSecondaryContainer
        tertiary = other.tertiary
        onTertiary = other.onTertiary
        tertiaryContainer = other.tertiaryContainer
        onTertiaryContainer = other.onTertiaryContainer
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
        surfaceVariant = other.surfaceVariant
        onSurfaceVariant = other.onSurfaceVariant
        surfaceTint = other.surfaceTint
        inverseSurface = other.inverseSurface
        inverseOnSurface = other.inverseOnSurface
        error = other.error
        onError = other.onError
        errorContainer = other.errorContainer
        onErrorContainer = other.onErrorContainer
        outline = other.outline
        outlineVariant = other.outlineVariant
        scrim = other.scrim
    }
}
