package xyz.foxinia.weathersampleapp.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import xyz.foxinia.weathersampleapp.data.Weather
import xyz.foxinia.weathersampleapp.ui.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WeatherCard(weather = Weather.mockWeather) {
            navController.navigate(Screen.Detail.route)
        }
    }
}

@Composable
fun WeatherCard(weather: Weather, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = weather.icon, contentDescription = "Weather Icon")
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "${weather.temperature}°", style = MaterialTheme.typography.h4)
                Text(text = "High: ${weather.high}° Low: ${weather.low}°")
            }
        }
    }
}