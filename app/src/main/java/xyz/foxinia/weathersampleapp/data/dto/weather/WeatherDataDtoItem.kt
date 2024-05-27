package xyz.foxinia.weathersampleapp.data.dto.weather

data class WeatherDataDtoItem(
    val current_weather: CurrentWeather,
    val current_weather_units: CurrentWeatherUnits,
    val elevation: Double,
    val generationtime_ms: Double,
    val latitude: Double,
    val location_id: Int,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)