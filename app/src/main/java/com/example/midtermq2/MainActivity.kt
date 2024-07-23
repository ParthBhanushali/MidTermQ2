package com.example.midtermq2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var citySpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        citySpinner = findViewById(R.id.citySpinner)

        val cities = resources.getStringArray(R.array.cities)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter = adapter

        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCity = cities[position]
                displayWeatherFragment(selectedCity)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        if (savedInstanceState == null) {
            displayWeatherFragment(cities[0])
        }
    }

    private fun displayWeatherFragment(city: String) {
        val weatherDescription = when (city) {
            "New York" -> "Sunny, Clear Skies"
            "Los Angeles" -> "Warm, Clear Skies"
            "Chicago" -> "Windy, Partly Cloudy"
            "Houston" -> "Humid, Thunderstorms"
            "Phoenix" -> "Hot, Sunny"
            else -> "Unknown Weather"
        }
        val temperature = when (city) {
            "New York" -> "25°"
            "Los Angeles" -> "28°"
            "Chicago" -> "18°"
            "Houston" -> "30°"
            "Phoenix" -> "35°"
            else -> "N/A"
        }

        val fragment = WeatherFragment.newInstance(city, weatherDescription, temperature)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
