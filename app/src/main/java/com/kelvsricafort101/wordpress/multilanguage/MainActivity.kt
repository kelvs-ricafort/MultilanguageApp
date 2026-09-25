package com.kelvsricafort101.wordpress.multilanguage

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kelvsricafort101.wordpress.multilanguage.data.LanguageManager
import com.kelvsricafort101.wordpress.multilanguage.ui.MultilanguageApp
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(
            LanguageManager.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultilanguageTheme {
                MultilanguageApp()
            }
        }
    }
}


