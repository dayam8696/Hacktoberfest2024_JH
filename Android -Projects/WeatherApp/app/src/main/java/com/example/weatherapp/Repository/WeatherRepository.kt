package com.example.weatherapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.utils.Constants.API_KEY
import okhttp3.Response

class WeatherRepository() {
    suspend fun getCurrentWeather() =
      RetrofitInstance.api.getCurrentWeather()
}
