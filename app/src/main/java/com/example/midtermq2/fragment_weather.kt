package com.example.midtermq2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class WeatherFragment : Fragment() {

    private lateinit var cityName: TextView
    private lateinit var weatherDescription: TextView
    private lateinit var temperature: TextView
    private lateinit var weatherIcon: ImageView
    private lateinit var temperatureIcon: ImageView
    private lateinit var humidityIcon: ImageView
    private lateinit var windIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        cityName = view.findViewById(R.id.cityName)
        weatherDescription = view.findViewById(R.id.weatherDescription)
        temperature = view.findViewById(R.id.temperature)
        weatherIcon = view.findViewById(R.id.weatherIcon)
        temperatureIcon = view.findViewById(R.id.temperatureIcon)
        humidityIcon = view.findViewById(R.id.humidityIcon)
        windIcon = view.findViewById(R.id.windIcon)
        arguments?.let {
            cityName.text = it.getString("cityName")
            weatherDescription.text = it.getString("weatherDescription")
            temperature.text = it.getString("temperature")
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(cityName: String, weatherDescription: String, temperature: String) =
            WeatherFragment().apply {
                arguments = Bundle().apply {
                    putString("cityName", cityName)
                    putString("weatherDescription", weatherDescription)
                    putString("temperature", temperature)
                }
            }
    }
}
