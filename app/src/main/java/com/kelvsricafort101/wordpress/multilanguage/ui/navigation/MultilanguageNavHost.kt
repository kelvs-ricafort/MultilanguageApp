package com.kelvsricafort101.wordpress.multilanguage.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kelvsricafort101.wordpress.multilanguage.ui.screens.home.HomeScreen
import com.kelvsricafort101.wordpress.multilanguage.ui.screens.settings.SettingsScreen
import com.kelvsricafort101.wordpress.multilanguage.viewmodel.MultilanguageViewModel

object AppDestinations {
    const val HOME = "home"
    const val SETTINGS = "settings"
    const val ABOUT = "about"
}

@Composable
fun MultilanguageNavHost(
    navController: NavHostController = rememberNavController()
) {
    val viewModel: MultilanguageViewModel = viewModel()
    val language by viewModel.language.collectAsState()

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
                onLanguageSelected = viewModel::setLanguage,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(AppDestinations.ABOUT) {

        }
    }
}