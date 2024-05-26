package xyz.foxinia.weathersampleapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.foxinia.weathersampleapp.detail.DetailScreen
import xyz.foxinia.weathersampleapp.home.HomeScreen
import xyz.foxinia.weathersampleapp.recent_locations.RecentLocationsScreen
import xyz.foxinia.weathersampleapp.settings.SettingsScreen

sealed class Screen(val route: String) {
    object Detail : Screen("detail")
}

@Composable
fun NavHostController.SetupNavGraph(navController: NavHostController,startDestination: String) {
    NavHost(navController = this, startDestination = startDestination) {
        composable(BottomNavItem.Home.route) { HomeScreen(navController) }
//        composable(BottomNavItem.RecentLocations.route) { RecentLocationsScreen(navController) }
        composable(BottomNavItem.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Detail.route) { DetailScreen(navController) }
    }
}