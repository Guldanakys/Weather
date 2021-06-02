package com.example.weather.data.model

import com.google.gson.annotations.SerializedName

data class CityWeather(

    @SerializedName("name")
    val name: String,

    @SerializedName("main")
    val main: Main,

    @SerializedName("weather")
    val weather: List<Weather>
)

data class Main (val temp: Double)

data class Weather (val description: String)