package com.example.mobile1project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreenNavigation(val route: String, val label: String, val icon: ImageVector) {
    object Ids : ScreenNavigation("IdsRoute", "Inicio", Icons.Default.Home)
    object FirstPartial : ScreenNavigation("FirstPartialRoute", "Parcial 1", Icons.Default.List)
    object SecondPartial : ScreenNavigation("SecondPartialRoute", "Parcial 2", Icons.Default.List)
    object ThirdPartial : ScreenNavigation("ThirdPartialRoute", "Parcial 3", Icons.Default.List)
}
