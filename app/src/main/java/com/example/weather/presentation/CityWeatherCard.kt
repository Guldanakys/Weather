package com.example.weather.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.data.model.CityWeather
import com.example.weather.data.model.Main
import com.example.weather.data.model.Weather

@Composable
fun CityWeatherCard(
    weather: CityWeather,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 12.dp,
                    end = 8.dp,
                    bottom = 12.dp,
                )
                .fillMaxWidth()
        ) {
            Text(
                text = weather.name,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = weather.main.temp.toString(),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .wrapContentWidth(Alignment.Start)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = weather.weather[0].description,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview("CityWeatherCard preview")
@Composable
fun DefaultPreview() {
    CityWeatherCard(weather = CityWeather(
        "Nur-Sultan",
        Main(28.32),
        arrayListOf(Weather("hot"))
        ), onClick = {}
    )
}