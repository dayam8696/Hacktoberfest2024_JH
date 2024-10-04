package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.databinding.HomeFragmentBinding
import com.example.weatherapp.ui.activites.MainActivity
import com.example.weatherapp.utils.Resource

class HomeFragment :BaseFragment() {
    private val binding by lazy { HomeFragmentBinding.inflate(layoutInflater) }
    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewmodel

        viewModel.getCurrentWeather()

        viewModel.currentWeatheer.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { weatherResponse ->
                        binding.apply {
                            tvTemp.text = "${weatherResponse.main.temp.toInt().toString()}°C"
                            tvMaxTemp.text = "Max temp:${weatherResponse.main.temp_max.toInt().toString()}°C"
                            tvMinTemp.text = "Min temp${weatherResponse.main.temp_min.toInt().toString()}°C"

                        }


                        Log.d("DYM", weatherResponse.toString())
                    }
                }

                is Resource.Error -> {

                    response.message?.let { message ->
                        Log.d("DYM", message)
                    }

                }

                is Resource.Loading -> {

                }
            }
        }

    }
}