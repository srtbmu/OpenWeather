package com.example.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.databinding.ActivityYandexBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView


class YandexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityYandexBinding
    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("4ab26d83-11d1-4a63-a5d6-a1c34c3b0189")
        binding = ActivityYandexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        yandexMapKit()
    }

    private fun yandexMapKit() {
        MapKitFactory.initialize(this)
        mapView = binding.mapview
        mapView.map.move(
            CameraPosition(Point(42.87954547234154, 74.61497645134712), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 300f), null
        )
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}