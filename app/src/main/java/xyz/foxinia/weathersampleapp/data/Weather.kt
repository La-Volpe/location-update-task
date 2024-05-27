package xyz.foxinia.weathersampleapp.data

data class Weather(
    val location: String,
    val description: String,
    val temperature: Int,
    val icon: String,
){
    companion object{
        val recentLocations = listOf(
            "Hamburg", "Lübeck", "Kiel", "Tallinn", "Rostock",
            "Danzig", "Bergen", "Riga", "Vyborg", "Stockholm"
        )

        val mockWeather = Weather(
            location = recentLocations.get(0),
            description = "Clear",
            temperature = 20,
            icon = "https://openweathermap.org/img/wn/01n@2x.png",
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