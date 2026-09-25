package com.kelvsricafort101.wordpress.multilanguage.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import java.util.Locale

@Composable
fun LocalizedApp(
    language: AppLanguage,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val currentConfiguration = LocalConfiguration.current

    val localizedConfiguration = remember(
        language,
        currentConfiguration
    ) {
        Configuration(currentConfiguration).apply {
            setLocale(
                Locale.forLanguageTag(language.code)
            )
        }
    }

    val localizedContext = remember(
        context, currentConfiguration
    ) {
        context.createConfigurationContext(
            localizedConfiguration
        )
    }

    CompositionLocalProvider(
        LocalConfiguration provides localizedConfiguration,
        LocalContext provides localizedContext
    ) {
        content()
    }
}