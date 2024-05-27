package xyz.foxinia.weathersampleapp.weather_looper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import xyz.foxinia.weathersampleapp.data.Weather
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 36.dp))
        WeatherCarousel(weatherList = Weather.weatherList)

    }
}

@Composable
fun WeatherCard(weather: Weather, isActive: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
            .width(LocalConfiguration.current.screenWidthDp.dp*0.85f)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = if (isActive) 20.dp else 8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isActive){
                TimerBar()
            }
            Text(text = weather.location, modifier = Modifier.padding(top = 128.dp))
            AsyncImage(model = weather.icon, contentDescription = "Weather Icon")
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "${weather.temperature}°", style = MaterialTheme.typography.h4)
                    Text(text = "High: ${weather.high}° Low: ${weather.low}°")
                }
            }
        }
    }
}

@Composable
fun WeatherCarousel(weatherList: List<Weather>) {
    var currentIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(10000L)
            currentIndex = (currentIndex + 1) % weatherList.size
            listState.animateScrollToItem(currentIndex)
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        userScrollEnabled = false
    ) {
        itemsIndexed(weatherList) { index, weather ->
            WeatherCard(weather = weather, isActive = index == currentIndex, onClick = {})
        }
    }
}
@Composable
fun TimerBar() {
    var progress by remember { mutableStateOf(0f) }
    var counter by remember { mutableStateOf(0)}

    LaunchedEffect(Unit) {
        repeat(100){
            delay(100) // wait 100 milliseconds
            progress += 0.01f
        }
        progress = 0f
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(1.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .height(4.dp)
                .background(
                    color = MaterialTheme.colors.primaryVariant,
                    shape = RoundedCornerShape(1.dp)
                )
        )
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun WeatherCardPreview() {
    WeatherCard(weather = Weather.mockWeather, isActive = true) {

    }
}