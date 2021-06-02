package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.lifecycle.ViewModelProvider
import com.example.weather.ui.theme.WeatherTheme
import java.util.*

class MainActivity : ComponentActivity() {

    private val mainViewModel by lazy {
        ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.initCities()

        setContent {
            WeatherTheme {
                ComposeNavigation(mainViewModel = mainViewModel)
            }
        }
    }
}