package com.kelvsricafort101.wordpress.multilanguage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kelvsricafort101.wordpress.multilanguage.MainActivity
import com.kelvsricafort101.wordpress.multilanguage.data.LanguageManager
import com.kelvsricafort101.wordpress.multilanguage.ui.navigation.MultilanguageNavHost
import com.kelvsricafort101.wordpress.multilanguage.viewmodel.MultilanguageViewModel

@Composable
fun MultilanguageApp() {
    val context = LocalContext.current

    val initialLanguage = remember(context) {
        LanguageManager.getLanguage(context)
    }

    val factory = remember(initialLanguage) {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MultilanguageViewModel(initialLanguage = initialLanguage) as T
            }
        }
    }

    val viewModel: MultilanguageViewModel = viewModel(factory = factory)
    val language by viewModel.language.collectAsState()

    MultilanguageNavHost(
        language = language,
        onLanguageSelected = { selectedLanguage ->
            LanguageManager.setLanguage(
                context = context,
                language = selectedLanguage
            )

            viewModel.setLanguage(selectedLanguage)

            context.let { it as? MainActivity }
                ?.recreate()
        }
    )
}