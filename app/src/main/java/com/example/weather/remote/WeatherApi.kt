package com.example.weather.remote

import com.example.weather.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("units") units: String,
        @Query("appid") appid: String = "d314c90db270348d9610d1752b1d4746",
    ): Call<Model>
}