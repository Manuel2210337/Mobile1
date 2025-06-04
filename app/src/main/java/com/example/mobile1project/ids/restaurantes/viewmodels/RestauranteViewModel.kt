package com.example.mobile1project.ids.restaurantes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.ids.restaurantes.models.Restaurante
import com.example.mobile1project.ids.restaurantes.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestauranteViewModel : ViewModel() {
    private val _restaurantes = MutableStateFlow<List<Restaurante>>(emptyList())
    val restaurantes: StateFlow<List<Restaurante>> = _restaurantes

    fun cargarRestaurantes() {
        viewModelScope.launch {
            try {
                val lista = RetrofitClient.api.obtenerRestaurantes()
                _restaurantes.value = lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}



