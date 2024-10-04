package com.example.weatherapp.api

import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=d1d76e6f74c25f60b602ac34a75cc0e5

// api.openweathermap.org/data/2.5/weather?q=new delhi,in&units=metric&appid=d1d76e6f74c25f60b602ac34a75cc0e5
interface WeatherApi {
//    @GET("/data/2.5/weather")
//    suspend fun getCurrentWeather(
//        @Query("lat")
//        lat :String = "10.91",
//        @Query("lon")
//        lng : String = "52.34",
//        @Query("units")
//        unit : String = "metric",
//        @Query("appid")
//        ApiKey :String = "d1d76e6f74c25f60b602ac34a75cc0e5"
//    ) :Response<CurrentWeather>
    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("q") city: String = "new delhi",
        @Query("c") country: String = "in",
        @Query("units") units: String = "metric",
        @Query("appid") appikey: String = API_KEY ,
    ): Response<CurrentWeather>

}