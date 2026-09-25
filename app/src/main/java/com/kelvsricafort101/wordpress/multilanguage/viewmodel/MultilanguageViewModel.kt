package com.kelvsricafort101.wordpress.multilanguage.viewmodel

import androidx.lifecycle.ViewModel
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MultilanguageViewModel(
    initialLanguage: AppLanguage
): ViewModel() {
    private val _language = MutableStateFlow(initialLanguage)
    val language: StateFlow<AppLanguage> = _language.asStateFlow()

    fun setLanguage(language: AppLanguage) {
        _language.value = language
    }
}