package com.example.weather.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weather.databinding.FragmentFirstBinding
import com.example.weather.model.Model
import com.example.weather.presenter.FirstPresenter
import com.example.weather.view.FirstView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("UNREACHABLE_CODE")
@AndroidEntryPoint
class FirstFragment : Fragment(), FirstView {

    @Inject
    lateinit var presenter: FirstPresenter
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        val lon = arguments?.getString("key_lon").toString()
        val lat = arguments?.getString("key_lat").toString()
        val units = arguments?.getString("key_units").toString()
        presenter.getWeatherDetails(lon.toDouble(), lat.toDouble(), units)
    }

    override fun showWeather(weatherModel: Model) {
        with(binding) {
            tvCountry.text = weatherModel.sys.country
            tvTemp.text = weatherModel.main.temp.toString()
            tvTempMin.text = weatherModel.main.temp_min.toString()
            tvTempMax.text = weatherModel.main.temp_max.toString()
            tvName.text = weatherModel.name
        }
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), "Error Service", Toast.LENGTH_SHORT).show()
    }
}