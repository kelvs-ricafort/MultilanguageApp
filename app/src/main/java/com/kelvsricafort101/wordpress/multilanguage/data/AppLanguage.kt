package com.kelvsricafort101.wordpress.multilanguage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kelvsricafort101.wordpress.multilanguage.R

enum class AppLanguage(
    val code: String,
    @StringRes val displayName: Int,
    @DrawableRes val flagRes: Int
) {
    ENGLISH(
        code = "en",
        displayName = R.string.language_english,
        flagRes = R.drawable.flag_us
    ),

    FILIPINO(
        code = "fil",
        displayName = R.string.language_filipino,
        flagRes = R.drawable.flag_filipino
    ),

    SPANISH(
        code = "es",
        displayName = R.string.language_spanish,
        flagRes = R.drawable.spanish_flag
    )
}