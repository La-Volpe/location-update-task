package xyz.foxinia.weathersampleapp.data.raw

data class WmoCode(
    val code: Int,
    val dayDescription: String,
    val nightDescription: String,
    val dayUrl: String,
    val nightUrl: String
)

object WmoCodes {
    val codes = listOf(
        WmoCode(
            code = 0,
            dayDescription = "Sunny",
            nightDescription = "Clear",
            dayUrl = "https://openweathermap.org/img/wn/01d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/01n@2x.png"
        ),
        WmoCode(
            code = 1,
            dayDescription = "Mainly Sunny",
            nightDescription = "Mainly Clear",
            dayUrl = "https://openweathermap.org/img/wn/01d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/01n@2x.png"
        ),
        WmoCode(
            code = 2,
            dayDescription = "Partly Cloudy",
            nightDescription = "Partly Cloudy",
            dayUrl = "https://openweathermap.org/img/wn/02d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/02n@2x.png"
        ),
        WmoCode(
            code = 3,
            dayDescription = "Cloudy",
            nightDescription = "Cloudy",
            dayUrl = "https://openweathermap.org/img/wn/03d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/03n@2x.png"
        ),
        WmoCode(
            code = 45,
            dayDescription = "Foggy",
            nightDescription = "Foggy",
            dayUrl = "https://openweathermap.org/img/wn/50d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/50n@2x.png"
        ),
        WmoCode(
            code = 48,
            dayDescription = "Rime Fog",
            nightDescription = "Rime Fog",
            dayUrl = "https://openweathermap.org/img/wn/50d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/50n@2x.png"
        ),
        WmoCode(
            code = 51,
            dayDescription = "Light Drizzle",
            nightDescription = "Light Drizzle",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 53,
            dayDescription = "Drizzle",
            nightDescription = "Drizzle",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 55,
            dayDescription = "Heavy Drizzle",
            nightDescription = "Heavy Drizzle",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 56,
            dayDescription = "Light Freezing Drizzle",
            nightDescription = "Light Freezing Drizzle",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 57,
            dayDescription = "Freezing Drizzle",
            nightDescription = "Freezing Drizzle",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 61,
            dayDescription = "Light Rain",
            nightDescription = "Light Rain",
            dayUrl = "https://openweathermap.org/img/wn/10d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/10n@2x.png"
        ),
        WmoCode(
            code = 63,
            dayDescription = "Rain",
            nightDescription = "Rain",
            dayUrl = "https://openweathermap.org/img/wn/10d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/10n@2x.png"
        ),
        WmoCode(
            code = 65,
            dayDescription = "Heavy Rain",
            nightDescription = "Heavy Rain",
            dayUrl = "https://openweathermap.org/img/wn/10d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/10n@2x.png"
        ),
        WmoCode(
            code = 66,
            dayDescription = "Light Freezing Rain",
            nightDescription = "Light Freezing Rain",
            dayUrl = "https://openweathermap.org/img/wn/10d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/10n@2x.png"
        ),
        WmoCode(
            code = 67,
            dayDescription = "Freezing Rain",
            nightDescription = "Freezing Rain",
            dayUrl = "https://openweathermap.org/img/wn/10d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/10n@2x.png"
        ),
        WmoCode(
            code = 71,
            dayDescription = "Light Snow",
            nightDescription = "Light Snow",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 73,
            dayDescription = "Snow",
            nightDescription = "Snow",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 75,
            dayDescription = "Heavy Snow",
            nightDescription = "Heavy Snow",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 77,
            dayDescription = "Snow Grains",
            nightDescription = "Snow Grains",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 80,
            dayDescription = "Light Showers",
            nightDescription = "Light Showers",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 81,
            dayDescription = "Showers",
            nightDescription = "Showers",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 82,
            dayDescription = "Heavy Showers",
            nightDescription = "Heavy Showers",
            dayUrl = "https://openweathermap.org/img/wn/09d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/09n@2x.png"
        ),
        WmoCode(
            code = 85,
            dayDescription = "Light Snow Showers",
            nightDescription = "Light Snow Showers",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 86,
            dayDescription = "Snow Showers",
            nightDescription = "Snow Showers",
            dayUrl = "https://openweathermap.org/img/wn/13d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/13n@2x.png"
        ),
        WmoCode(
            code = 95,
            dayDescription = "Thunderstorm",
            nightDescription = "Thunderstorm",
            dayUrl = "https://openweathermap.org/img/wn/11d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/11n@2x.png"
        ),
        WmoCode(
            code = 96,
            dayDescription = "Light Thunderstorms With Hail",
            nightDescription = "Light Thunderstorms With Hail",
            dayUrl = "https://openweathermap.org/img/wn/11d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/11n@2x.png"
        ),
        WmoCode(
            code = 99,
            dayDescription = "Thunderstorm With Hail",
            nightDescription = "Thunderstorm With Hail",
            dayUrl = "https://openweathermap.org/img/wn/11d@2x.png",
            nightUrl = "https://openweathermap.org/img/wn/11n@2x.png"
        )
    )
}
