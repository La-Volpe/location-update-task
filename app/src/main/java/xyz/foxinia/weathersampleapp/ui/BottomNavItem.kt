package xyz.foxinia.weathersampleapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object RecentLocations : BottomNavItem("recentLocations", Icons.Default.LocationOn, "Locations")
    object Settings : BottomNavItem("settings", Icons.Default.Settings, "Settings")
}