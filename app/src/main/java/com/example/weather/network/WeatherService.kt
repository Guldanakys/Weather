package com.example.weather.network

import com.example.weather.data.model.CityWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getCityWeather(
        @Query("q") query: String,
        @Query("appid") key: String = "53a2d1f721c6f5ef2b0391a1f4722416",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru"
    ): CityWeather
}