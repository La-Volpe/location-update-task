package xyz.foxinia.weathersampleapp.weather_looper

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.request.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.foxinia.weathersampleapp.R


@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    /**
     * Collect the weather data from the view model
     */
    val weatherList = viewModel.weather.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 36.dp))
        weatherList.value?.let { weatherList ->
            WeatherCarousel(weatherList)
        }
    }
}

@Composable
fun WeatherCard(weather: Weather, isActive: Boolean, onClick: () -> Unit) {
    /**
     *
     */
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
            .width(LocalConfiguration.current.screenWidthDp.dp * 0.85f)
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
            Text(text = weather.location, modifier = Modifier.padding(top = 128.dp), style = MaterialTheme.typography.h3)
            Card {
                AsyncImage(
                    model = weather.icon,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
            Text(text = "${weather.temperature}°C", style = MaterialTheme.typography.h4,modifier = Modifier.padding(top = 12.dp))
            Text(text = weather.description, style = MaterialTheme.typography.h4,modifier = Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun WeatherCarousel(weatherList: ArrayList<Weather>) {
    // The current index of the weather list
    var currentIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()

    // Automatically scroll through the weather list
    LaunchedEffect(Unit) {
        while (true) {
            delay(10000L)
            currentIndex = (currentIndex + 1) % weatherList.size
            listState.animateScrollToItem(currentIndex)
        }
    }

    // Display the weather list
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
    // Progress of the timer bar
    var progress by remember { mutableStateOf(0f) }
    // Animate the progress of the timer bar
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
                .fillMaxWidth(progress) // Set the width of the box to the progress
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