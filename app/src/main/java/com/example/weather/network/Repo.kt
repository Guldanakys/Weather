package com.example.weather.network

import com.example.weather.data.model.CityWeather

object Repo {

    suspend fun getCityWeather(name: String): CityWeather {

        return RetrofitClient.service.getCityWeather(name)
    }
}