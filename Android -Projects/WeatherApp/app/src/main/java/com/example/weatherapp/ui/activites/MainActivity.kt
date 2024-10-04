package com.example.weatherapp.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.ViewModel.WeatherViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel :WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weatherRepository = WeatherRepository()
        val viewModelProviderFactory =WeatherViewModelProviderFactory(weatherRepository)
        viewmodel = ViewModelProvider(this,viewModelProviderFactory).get(WeatherViewModel::class.java)
    }
}