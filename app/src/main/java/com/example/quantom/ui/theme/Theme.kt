package com.example.quantom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = White,
    secondary = GreenPrimary,
    onSecondary = White,
    surface = GreenCardBackground, // Card background color
    onSurface = Black, // Card content color
    background = GreenSecondary,
    onBackground = Black,
    error = Color.Red,
    onError = White
)

private val DarkColorScheme = darkColorScheme(
    primary = GreenPrimary,
    onPrimary = Black,
    secondary = GreenPrimary,
    onSecondary = Black,
    surface = GreenCardBackground, // Card background color
    onSurface = Black, // Card content color
    background = GreenSecondary,
    onBackground = Black,
    error = Color.Red,
    onError = Black
)


@Composable
fun QuantomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(),
        shapes = Shapes(),
        content = content
    )
}
