package com.example.mobile1project.ids.restaurantes.navigation

sealed class Screens(val route: String) {
    object Lista : Screens("lista")
    object Detalle : Screens("detalle")
}
