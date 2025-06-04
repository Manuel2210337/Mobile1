// Archivo: RestauranteApiService.kt
package com.example.mobile1project.ids.restaurantes.network

import com.example.mobile1project.ids.restaurantes.models.Restaurante
import retrofit2.http.GET

interface RestauranteApiService {
    @GET("https://gist.githubusercontent.com/jorgegit/f1c89ab2e409c98ec618fdb9e75077bd/raw/15e41a39c9c251cad31639feabf0ce4ba131bb19/restaurants.json")
    suspend fun obtenerRestaurantes(): List<Restaurante>
}
