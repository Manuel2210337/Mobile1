package com.example.mobile1project.ids.restaurantes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.mobile1project.ids.restaurantes.viewmodels.RestauranteViewModel
import com.example.mobile1project.ids.restaurantes.models.Restaurante
import com.example.mobile1project.ids.restaurantes.views.RestauranteDetalleScreen
import com.example.mobile1project.ids.restaurantes.views.PantallaRestaurantes
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun NavGraph(navController: NavHostController, viewModel: RestauranteViewModel) {
    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {

        composable("lista") {
            PantallaRestaurantes(viewModel, navController)
        }

        composable(
            route = "detalle/{nombre}/{calificacion}/{costoEnvio}/{tiempoEntrega}/{imagenUrl}/{lat}/{lng}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("calificacion") { type = NavType.StringType },
                navArgument("costoEnvio") { type = NavType.StringType },
                navArgument("tiempoEntrega") { type = NavType.StringType },
                navArgument("imagenUrl") { type = NavType.StringType },
                navArgument("lat") { type = NavType.StringType },
                navArgument("lng") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val args = backStackEntry.arguments!!

            val nombre = URLDecoder.decode(args.getString("nombre") ?: "", StandardCharsets.UTF_8.toString())
            val calificacion = URLDecoder.decode(args.getString("calificacion") ?: "0.0", StandardCharsets.UTF_8.toString()).toDouble()
            val costoEnvio = URLDecoder.decode(args.getString("costoEnvio") ?: "0.0", StandardCharsets.UTF_8.toString()).toDouble()
            val tiempoEntrega = URLDecoder.decode(args.getString("tiempoEntrega") ?: "0", StandardCharsets.UTF_8.toString()).toInt()
            val imagenUrl = URLDecoder.decode(args.getString("imagenUrl") ?: "", StandardCharsets.UTF_8.toString())
            val lat = URLDecoder.decode(args.getString("lat") ?: "0.0", StandardCharsets.UTF_8.toString()).toDouble()
            val lng = URLDecoder.decode(args.getString("lng") ?: "0.0", StandardCharsets.UTF_8.toString()).toDouble()

            val restaurante = Restaurante(
                nombre = nombre,
                calificacion = calificacion,
                costoEnvio = costoEnvio,
                tiempoEntrega = tiempoEntrega,
                imagenUrl = imagenUrl,
                latitud = lat,
                longitud = lng
            )

            RestauranteDetalleScreen(
                restaurante = restaurante,
                onLlamarClick = { /* lógica para llamar */ },
                onSitioWebClick = { /* lógica para abrir sitio web */ }
            )
        }
    }
}

