package com.kelvsricafort101.wordpress.multilanguage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kelvsricafort101.wordpress.multilanguage.ui.MultilanguageApp
import com.kelvsricafort101.wordpress.multilanguage.ui.theme.MultilanguageTheme

class MainActivity : ComponentActivity() {
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


