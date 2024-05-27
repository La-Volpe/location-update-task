package xyz.foxinia.weathersampleapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.foxinia.weathersampleapp.data.dto.weather.WeatherDataDto

interface Api {
    @GET("/v1/forecast")
    suspend fun getWeatherForList(
        @Query(value = "latitude", encoded = true) latitude: String,
        @Query(value = "longitude", encoded = true) longitude: String,
        @Query(value = "timezone", encoded = true) timezone: String,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("current") currentParams: String = "wmo"
    ): Response<WeatherDataDto>
}