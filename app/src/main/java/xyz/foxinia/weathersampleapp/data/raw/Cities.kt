package xyz.foxinia.weathersampleapp.data.raw

/**
 * A data class that represents our input cities with their coordinates.
 */
object Cities {
    val list = listOf(
        Location("Hamburg",53.619653,10.079969),
        Location("Bremen", 53.080917,8.847533),
        Location("Hanover",52.378385,9.794862),
        Location("Berlin",52.496385,13.444041),
        Location("Lübeck", 53.866865,10.739542),
        Location("Kiel",54.304540,10.152741),
        Location("Flensburg", 54.797277,9.491039),
        Location("Wolfsburg",52.426412,10.821392),
        Location("Bremenhaven",53.542788,8.613462),
        Location("Oldenburg",53.141598,8.242565),


    )
}
data class Location(val name: String, val latitude: Double, val longitude: Double)
