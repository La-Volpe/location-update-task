package xyz.foxinia.weathersampleapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.foxinia.weathersampleapp.detail.DetailScreen
import xyz.foxinia.weathersampleapp.weather_looper.HomeScreen
import xyz.foxinia.weathersampleapp.settings.SettingsScreen

sealed class AppScreen(val route: String) {
    object Detail : AppScreen("detail")
}

@Composable
fun NavHostController.SetupNavGraph(navController: NavHostController,startDestination: String) {
    NavHost(navController = this, startDestination = startDestination) {
        composable(BottomNavItem.Home.route) { HomeScreen(navController) }
//        composable(BottomNavItem.RecentLocations.route) { RecentLocationsScreen(navController) }
        composable(BottomNavItem.Settings.route) { SettingsScreen(navController) }
        composable(AppScreen.Detail.route) { DetailScreen(navController) }
    }
}