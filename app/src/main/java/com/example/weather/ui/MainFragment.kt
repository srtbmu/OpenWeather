package com.example.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentMainBinding
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateTo()
        binding.btnNavigate.setOnClickListener {
            findNavController().navigate(R.id.yandexActivity)
        }
    }

    private fun navigateTo() {
        binding.btnSend.setOnClickListener {
            if (binding.etFirst.length() != 0 && binding.etSecond.length() != 0 && binding.etUnits.length() != 0) {
                val lon = binding.etFirst.text.toString()
                val lat = binding.etSecond.text.toString()
                val units = binding.etUnits.text.toString()
                findNavController().navigate(
                    R.id.firstFragment,
                    bundleOf("key_lon" to lon, "key_lat" to lat, "key_units" to units)
                )
            } else {
                Toast.makeText(requireContext(), "Заполните строки", Toast.LENGTH_SHORT).show()
            }
        }
    }
}