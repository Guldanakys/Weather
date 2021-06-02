package com.example.weather.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.weather.ui.theme.Purple500

@Composable
fun CityWeatherList(navController: NavController, mainViewModel: MainViewModel) {
    val cities by mainViewModel.listLiveData.observeAsState()
    Scaffold(
        topBar = { TopAppBar(title = { Text("Погода") }, backgroundColor = Purple500) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addCity") },
                contentColor = Color.White) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {
        if (cities.isNullOrEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        } else {
            Column(modifier = Modifier.fillMaxHeight()) {
                cities?.let { it1 ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(color = MaterialTheme.colors.background)
                    ) {
                        itemsIndexed(items = it1) { _, weather ->
                            CityWeatherCard(weather = weather, onClick = {})
                        }
                    }
                }
            }
        }
    }
}