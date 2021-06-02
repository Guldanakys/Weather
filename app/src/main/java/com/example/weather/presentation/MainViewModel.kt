package com.example.weather.presentation

import androidx.lifecycle.*
import com.example.weather.data.model.CityWeather
import com.example.weather.data.DataStore
import com.example.weather.network.Repo
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    val listLiveData: LiveData<ArrayList<CityWeather>>
        get() = list

    private val list = MutableLiveData<ArrayList<CityWeather>>()
    private val cityList = DataStore.getCities()
    private val networkList = mutableListOf<CityWeather>()

    fun initCities() {
        clearLists()
        val deferredList = mutableListOf<Deferred<Boolean>>()
        viewModelScope.launch {
            cityList.forEach {
                val call = async {
                    networkList.add(Repo.getCityWeather(it))
                }
                deferredList.add(call)
            }
            deferredList.awaitAll()
            list.postValue(networkList as ArrayList<CityWeather>?)
        }
    }

    fun clearLists() {
        list.postValue(null)
        networkList.clear()
    }
}