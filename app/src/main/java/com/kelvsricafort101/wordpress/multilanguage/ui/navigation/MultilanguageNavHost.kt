package com.kelvsricafort101.wordpress.multilanguage.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kelvsricafort101.wordpress.multilanguage.data.AppLanguage
import com.kelvsricafort101.wordpress.multilanguage.ui.screens.about.AboutAppScreen
import com.kelvsricafort101.wordpress.multilanguage.ui.screens.home.HomeScreen
import com.kelvsricafort101.wordpress.multilanguage.ui.screens.settings.SettingsScreen

object AppDestinations {
    const val HOME = "home"
    const val SETTINGS = "settings"
    const val ABOUT = "about"
}

@Composable
fun MultilanguageNavHost(
    language: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.HOME
    ) {
        composable(AppDestinations.HOME) {
            HomeScreen(
                language = language,
                onSettingsClick = {
                    navController.navigate(AppDestinations.SETTINGS)
                },
                onAboutClick = {
                    navController.navigate(AppDestinations.ABOUT)
                }
            )
        }
        composable(AppDestinations.SETTINGS) {
            SettingsScreen(
                language = language,
                onLanguageSelected = onLanguageSelected,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(AppDestinations.ABOUT) {
            AboutAppScreen(
                language = language,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}