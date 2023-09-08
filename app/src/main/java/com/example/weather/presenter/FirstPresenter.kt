package com.example.weather.presenter

import com.example.weather.model.Model
import com.example.weather.model.WeatherApi
import com.example.weather.view.FirstView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FirstPresenter @Inject constructor(private val weatherApi: WeatherApi) {

    lateinit var firstView: FirstView
    fun getWeatherDetails(lon: Double, lat: Double, units: String) {
        weatherApi.getCurrentWeather(lon, lat, units).enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                response.body()?.let {
                    firstView.showWeather(it)
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                firstView.showError(t.message.toString())
            }
        })
    }

    fun attachView(firstView: FirstView) {
        this.firstView = firstView
    }
}