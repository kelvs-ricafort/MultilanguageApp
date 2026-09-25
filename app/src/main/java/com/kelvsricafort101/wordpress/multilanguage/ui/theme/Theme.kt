package com.kelvsricafort101.wordpress.multilanguage.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BluePrimaryLight,
    onPrimary = DarkTextPrimary,
    primaryContainer = BluePrimaryDark,
    onPrimaryContainer = AppSurface,
    secondary = TealSecondaryLight,
    onSecondary = DarkTextPrimary,
    secondaryContainer = TealSecondaryDark,
    onSecondaryContainer = AppSurface,
    tertiary = GoldAccent,
    onTertiary = DarkTextPrimary,
    background = DarkBackground,
    onBackground = AppSurface,
    surface = DarkSurface,
    onSurface = AppSurface,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = DarkTextSecondary,
    error = ErrorRedLight,
    onError = AppSurface
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = AppSurface,
    primaryContainer = BluePrimaryLight,
    onPrimaryContainer = TextPrimary,
    secondary = TealSecondary,
    onSecondary = AppSurface,
    secondaryContainer = TealSecondaryLight,
    onSecondaryContainer = TextPrimary,
    tertiary = GoldAccent,
    onTertiary = TextPrimary,
    background = AppBackground,
    onBackground = TextPrimary,
    surface = AppSurface,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = TextSecondary,
    error = ErrorRed,
    onError = AppSurface
)

@Composable
fun MultilanguageTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}