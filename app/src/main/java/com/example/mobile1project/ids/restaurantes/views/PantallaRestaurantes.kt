package com.example.mobile1project.ids.restaurantes.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.mobile1project.ids.restaurantes.models.Restaurante
import com.example.mobile1project.ids.restaurantes.navigation.Screens
import com.example.mobile1project.ids.restaurantes.viewmodels.RestauranteViewModel
import com.example.mobile1project.ids.restaurantes.views.RestauranteItem
import java.net.URLEncoder

@Composable
fun PantallaRestaurantes(viewModel: RestauranteViewModel, navController: NavHostController) {

    // Aquí llamamos a cargarRestaurantes una vez cuando el composable entra en composición
    LaunchedEffect(Unit) {
        viewModel.cargarRestaurantes()
    }

    val restaurantes = viewModel.restaurantes.collectAsState(initial = emptyList())

    LazyColumn {
        items(restaurantes.value) { restaurante ->
            RestauranteItem(restaurante = restaurante) {
                val nombreEnc = URLEncoder.encode(restaurante.nombre, "UTF-8")
                val imagenEnc = URLEncoder.encode(restaurante.imagenUrl, "UTF-8")
                val calificacionEnc = URLEncoder.encode(restaurante.calificacion.toString(), "UTF-8")
                val costoEnc = URLEncoder.encode(restaurante.costoEnvio.toString(), "UTF-8")
                val tiempoEnc = URLEncoder.encode(restaurante.tiempoEntrega.toString(), "UTF-8")
                val latEnc = URLEncoder.encode(restaurante.latitud.toString(), "UTF-8")
                val lngEnc = URLEncoder.encode(restaurante.longitud.toString(), "UTF-8")

                val ruta = "${Screens.Detalle.route}/$nombreEnc/$calificacionEnc/$costoEnc/$tiempoEnc/$imagenEnc/$latEnc/$lngEnc"

                navController.navigate(ruta)
            }
        }
    }
}








