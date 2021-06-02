package com.example.weather.data

object DataStore {

    private val currentCityList = mutableListOf("Алматы", "Нур-Султан", "Караганда")
    private val defaultCityList = mutableListOf(
        "Актау",
        "Актобе",
        "Атырау",
        "Костанай",
        "Павлодар",
        "Петропавловск",
        "Шымкент",
        "Уральск",
        "Алматы",
        "Нур-Султан",
        "Караганда"
    )

    fun addCity(name: String) {
        currentCityList.add(name)
    }

    fun getCities(): MutableList<String> {
        return currentCityList
    }

    fun getDefaultCities(): MutableList<String> {
        return defaultCityList
    }
}