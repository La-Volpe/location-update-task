package xyz.foxinia.weathersampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import xyz.foxinia.weathersampleapp.ui.BottomNavItem
import xyz.foxinia.weathersampleapp.ui.BottomNavigationBar
import xyz.foxinia.weathersampleapp.ui.Screen
import xyz.foxinia.weathersampleapp.ui.SetupNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding ->
                Surface(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                    navController.SetupNavGraph(navController,startDestination = BottomNavItem.Home.route)
                }
            }
        }
    }
}