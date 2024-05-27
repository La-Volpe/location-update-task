package xyz.foxinia.weathersampleapp.weather_looper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import xyz.foxinia.weathersampleapp.data.Weather
import xyz.foxinia.weathersampleapp.data.raw.Cities
import xyz.foxinia.weathersampleapp.data.raw.WmoCodes
import xyz.foxinia.weathersampleapp.data.remote.Api
import javax.inject.Inject
/**
 * A ViewModel class for the Home screen.
 *
 * @property api The API service to fetch weather data.
 * @property _weather A private MutableStateFlow that holds the weather data.
 * @property weather A public StateFlow that exposes the weather data.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val api: Api): ViewModel(){
    private val _weather = MutableStateFlow<ArrayList<Weather>?>(null)
    val weather: StateFlow<ArrayList<Weather>?> = _weather

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        val weatherData = ArrayList<Weather>()

        viewModelScope.launch {
            val weatherResponse = api.getWeatherForList(
                getListOfLatitudes(),
                getListOfLongitudes(),
                "Europe/Berlin"
            ).apply {
                if (isSuccessful) {
                    /*
                    * We iterate over the response body and create a Weather object for each city.
                     */
                    body()!!.forEachIndexed() { index, weather ->
                        val isDay = (weather.current_weather.is_day == 1)
                        var description = ""
                        var icon = ""
                        /*
                        * We check if it is day or night and get the appropriate description and icon.
                         */
                        if(isDay){
                            description = WmoCodes.codes.find { it.code == weather.current_weather.weathercode }!!.dayDescription
                            icon = WmoCodes.codes.find { it.code == weather.current_weather.weathercode }!!.dayUrl
                        } else{
                            description = WmoCodes.codes.find { it.code == weather.current_weather.weathercode }!!.nightDescription
                            icon = WmoCodes.codes.find { it.code == weather.current_weather.weathercode }!!.nightUrl
                        }
                        val tempWeatherItem: Weather = Weather(
                            Cities.list[index].name,
                            description,
                            weather.current_weather.temperature.toInt(),
                            icon)
                        weatherData.add(tempWeatherItem)
                    }
                }
            }

            // We update the StateFlow with the weather data.
            _weather.value = weatherData
        }
    }

    private fun getListOfLatitudes(): String{
        var latitudes = ""
        for (city in Cities.list){
            latitudes += "${city.latitude},"
        }
        return latitudes
    }
    private fun getListOfLongitudes(): String{
        var longitudes = ""
        for (city in Cities.list){
            longitudes += "${city.longitude},"
        }
        return longitudes
    }
}