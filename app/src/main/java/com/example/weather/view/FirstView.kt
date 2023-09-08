package com.example.weather.view

import com.example.weather.model.Model

interface FirstView {

    fun showWeather(weatherModel: Model)

    fun showError(message: String)
}