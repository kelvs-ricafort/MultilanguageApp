package com.kelvsricafort101.wordpress.multilanguage.ui.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kelvsricafort101.wordpress.multilanguage.BuildConfig
import com.kelvsricafort101.wordpress.multilanguage.R
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

@Composable
fun AboutAppScreen(
    language: AppLanguage,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    key(language) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.about_app)
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val version = BuildConfig.VERSION_NAME
                val build = BuildConfig.VERSION_CODE
                Text(
                    text = stringResource(R.string.app_name)
                )
                Text(
                    text = stringResource(R.string.about_description)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(
                                    stringResource(R.string.version, "").substringBefore(":").trim()
                                )
                                append(": ")
                            }
                            append(version)
                        },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(
                                    stringResource(R.string.build, 0).substringBefore(":").trim()
                                )
                                append(": ")
                            }
                            append(build.toString())
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutAppScreenPreview() {
    MultilanguageTheme {
        AboutAppScreen(
            language = AppLanguage.ENGLISH,
            onNavigateBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutAppScreenDarkPreview() {
    MultilanguageTheme(darkTheme = true) {
        Surface {
            AboutAppScreen(
                language = AppLanguage.ENGLISH,
                onNavigateBack = {}
            )
        }
    }
}