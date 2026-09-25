package com.kelvsricafort101.wordpress.multilanguage.data

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import androidx.core.content.edit
import java.util.Locale

object LanguageManager {
    private const val PREFS_NAME = "language_preferences"
    private const val LANGUAGE_KEY = "language"

    fun getLanguage(context: Context): AppLanguage {
        val code = context
            .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getString(LANGUAGE_KEY, AppLanguage.ENGLISH.code)
            ?: AppLanguage.ENGLISH.code

        return AppLanguage.entries.firstOrNull {
            it.code == code
        } ?: AppLanguage.ENGLISH
    }

    fun setLanguage(
        context: Context,
        language: AppLanguage
    ) {
        context
            .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit {
                putString(LANGUAGE_KEY, language.code)
            }
    }

    fun wrap(context: Context): ContextWrapper {
        val language = getLanguage(context)
        val locale = Locale.forLanguageTag(language.code)

        Locale.setDefault(locale)

        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)

        val localizedContext = context.createConfigurationContext(configuration)

        return ContextWrapper(localizedContext)
    }
}