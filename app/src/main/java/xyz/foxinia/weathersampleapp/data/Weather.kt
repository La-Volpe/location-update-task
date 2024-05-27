package xyz.foxinia.weathersampleapp.data

data class Weather(
    val location: String,
    val temperature: Int,
    val high: Int,
    val low: Int,
    // URL for the weather icon:
    val icon: String,
    val windSpeed: Double,
    val precipitation: Double,
    val humidity: Int,
    val sunrise: String,
    val sunset: String,
    val forecast: List<Forecast>
){
    companion object{
        val recentLocations = listOf(
            "Hamburg", "Lübeck", "Kiel", "Tallinn", "Rostock",
            "Danzig", "Bergen", "Riga", "Vyborg", "Stockholm"
        )

        val mockWeather = Weather(
            location = recentLocations.get(0),
            temperature = 20,
            high = 22,
            low = 15,
            icon = "https://openweathermap.org/img/wn/01n@2x.png",
            windSpeed = 5.5,
            precipitation = 0.1,
            humidity = 60,
            sunrise = "6:00 AM",
            sunset = "8:00 PM",
            forecast = listOf(
                Forecast("Mon", 22, 15, "https://openweathermap.org/img/wn/01n@2x.png"),
                Forecast("Tue", 21, 14, "https://openweathermap.org/img/wn/01n@2x.png"),
                Forecast("Wed", 20, 13, "https://openweathermap.org/img/wn/01n@2x.png"),
                // Add more days...
            )
        )
        val weatherList = listOf(
            mockWeather,
            mockWeather.copy(location = recentLocations.get(1)),
            mockWeather.copy(location = recentLocations.get(2)),
            mockWeather.copy(location = recentLocations.get(3)),
            mockWeather.copy(location = recentLocations.get(4)),
            mockWeather.copy(location = recentLocations.get(5)),
            mockWeather.copy(location = recentLocations.get(6)),
            mockWeather.copy(location = recentLocations.get(7)),
            mockWeather.copy(location = recentLocations.get(8)),
            mockWeather.copy(location = recentLocations.get(9))
        )
    }
}