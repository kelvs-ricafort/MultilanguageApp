package com.kelvsricafort101.wordpress.multilanguage.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kelvsricafort101.wordpress.multilanguage.R
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

@Composable
fun SettingsScreen(
    language: AppLanguage,
    modifier: Modifier = Modifier,
    onLanguageSelected: (AppLanguage) -> Unit,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.settings)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.settings_description)
            )

            LanguageSelector(
                language = language,
                onLanguageSelected = onLanguageSelected
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MultilanguageTheme {
        SettingsScreen(
            language = AppLanguage.ENGLISH,
            onLanguageSelected = { },
            onNavigateBack = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenDarkPreview() {
    MultilanguageTheme(darkTheme = true) {
        Surface {
            SettingsScreen(
                language = AppLanguage.ENGLISH,
                onLanguageSelected = { },
                onNavigateBack = { }
            )
        }
    }
}