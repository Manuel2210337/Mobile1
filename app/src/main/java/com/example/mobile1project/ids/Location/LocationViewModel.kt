package com.example.mobile1project.ids.Location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel : ViewModel() {

    private val apiService = LocationApiService.create()
    private val repository = LocationRepository(apiService)

    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations = _locations.asStateFlow()

    init {
        loadLocations()
    }

    private fun loadLocations() {
        viewModelScope.launch {
            try {
                _locations.value = repository.fetchLocations()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}