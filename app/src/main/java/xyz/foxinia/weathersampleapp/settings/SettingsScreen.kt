package xyz.foxinia.weathersampleapp.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SettingsScreen(navController: NavHostController) {
    var isMetric by remember { mutableStateOf(false) }
    var isDarkTheme by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Settings", style = MaterialTheme.typography.h4)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = "Units")
            Switch(
                checked = isMetric,
                onCheckedChange = { isMetric = it },
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(text = if (isMetric) "Metric" else "Imperial", modifier = Modifier.padding(start = 8.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = "Theme")
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { isDarkTheme = it },
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(text = if (isDarkTheme) "Dark" else "Light", modifier = Modifier.padding(start = 8.dp))
        }
    }
}
