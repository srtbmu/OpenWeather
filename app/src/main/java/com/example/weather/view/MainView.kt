package com.example.weather.view

import com.example.weather.model.WeatherModel

interface MainView {

    fun showWeather(weather: WeatherModel)

    fun showError(message:String)
}