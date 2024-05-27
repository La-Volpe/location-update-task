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
                    body()!!.forEachIndexed() { index, weather ->
                        val isDay = (weather.current_weather.is_day == 1)
                        var description = ""
                        var icon = ""
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