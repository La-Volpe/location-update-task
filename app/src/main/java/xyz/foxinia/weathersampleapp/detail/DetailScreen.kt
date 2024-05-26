package xyz.foxinia.weathersampleapp.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import xyz.foxinia.weathersampleapp.data.Forecast
import xyz.foxinia.weathersampleapp.data.Weather.Companion.mockWeather

@Composable
fun DetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = mockWeather.location, style = MaterialTheme.typography.h4)
        Text(text = "Temperature: ${mockWeather.temperature}°")
        Text(text = "Wind Speed: ${mockWeather.windSpeed} m/s")
        Text(text = "High: ${mockWeather.high}° Low: ${mockWeather.low}°")
        Text(text = "Precipitation: ${mockWeather.precipitation} mm")
        Text(text = "Humidity: ${mockWeather.humidity}%")
        Text(text = "Sunrise: ${mockWeather.sunrise}")
        Text(text = "Sunset: ${mockWeather.sunset}")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "7 Day Forecast", style = MaterialTheme.typography.h6)
        LazyColumn {
            items(mockWeather.forecast) { forecast ->
                ForecastItem(forecast)
            }
        }
    }
}

@Composable
fun ForecastItem(forecast: Forecast) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(model = forecast.icon, contentDescription = "Weather Icon")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${forecast.day}: High ${forecast.high}° Low ${forecast.low}°")
    }
}
