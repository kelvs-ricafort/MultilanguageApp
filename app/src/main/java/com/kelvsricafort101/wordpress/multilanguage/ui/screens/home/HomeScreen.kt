package com.kelvsricafort101.wordpress.multilanguage.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kelvsricafort101.wordpress.multilanguage.R
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

@Composable
fun HomeScreen(
    language: AppLanguage,
    modifier : Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    val languageNane = stringResource(language.displayName)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.home)
                    )
                },
                actions = {
                    IconButton(
                        onClick = onSettingsClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = stringResource(R.string.settings)
                        )
                    }

                    IconButton(
                        onClick = onAboutClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = stringResource(R.string.about_app)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.welcome)
            )

            Text(
                text = stringResource(R.string.welcome_message)
            )

            Text(
                text = languageNane
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MultilanguageTheme {
        HomeScreen(
            language = AppLanguage.ENGLISH,
            onSettingsClick = {},
            onAboutClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenDarkPreview() {
    MultilanguageTheme(darkTheme = true) {
        Surface() {
            HomeScreen(
                language = AppLanguage.ENGLISH,
                onSettingsClick = {},
                onAboutClick = {}
            )
        }
    }
}