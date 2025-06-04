package com.example.mobile1project.ids.Location

class LocationRepository(private val apiService: LocationApiService) {
    suspend fun fetchLocations(): List<Location> {
        return apiService.getLocations()
    }
}

