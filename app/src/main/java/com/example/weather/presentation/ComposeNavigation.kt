package com.example.weather.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ComposeNavigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "cityWeatherList"
    ) {
        composable("cityWeatherList") {
            CityWeatherList(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
        composable("addCity") {
            AddCity(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}