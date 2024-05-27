package xyz.foxinia.weathersampleapp.data.dto.weather

data class CurrentWeather(
    val interval: Int,
    val is_day: Int,
    val temperature: Double,
    val time: String,
    val weathercode: Int,
    val winddirection: Int,
    val windspeed: Double
)