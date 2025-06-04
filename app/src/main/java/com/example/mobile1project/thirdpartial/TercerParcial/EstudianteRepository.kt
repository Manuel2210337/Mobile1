package com.example.mobile1project.thirdpartial.TercerParcial

import com.example.mobile1project.thirdpartial.TercerParcial.models.Estudiante

class EstudianteRepository(private val apiService: EstudianteApiService) {
    suspend fun obtenerEstudiantes(): List<Estudiante> {
        return apiService.getEstudiantes()
    }
}
