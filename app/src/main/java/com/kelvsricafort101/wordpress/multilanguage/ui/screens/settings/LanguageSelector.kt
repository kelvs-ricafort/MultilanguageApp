package com.kelvsricafort101.wordpress.multilanguage.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kelvsricafort101.wordpress.multilanguage.R
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

@Composable
fun LanguageSelector(
    language: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expanded = true
                }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Language,
                contentDescription = stringResource(R.string.language)
            )

            Text(
                text = stringResource(language.displayName),
                modifier = Modifier.padding(start = 16.dp)
            )

            Image(
                painter = painterResource(language.flagRes),
                contentDescription = stringResource(language.displayName),
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(32.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = !expanded
            }
        ) {
            AppLanguage.entries.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(item.flagRes),
                                contentDescription = stringResource(item.displayName),
                                modifier = Modifier.size(32.dp)
                            )

                            Text(
                                text = stringResource(item.displayName),
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    },
                    onClick = {
                        onLanguageSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorPreview() {
    MultilanguageTheme {
        LanguageSelector(
            language = AppLanguage.ENGLISH,
            onLanguageSelected = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorDarkPreview() {
    MultilanguageTheme(darkTheme = true) {
        Surface {
            LanguageSelector(
                language = AppLanguage.ENGLISH,
                onLanguageSelected = {}
            )
        }
    }
}