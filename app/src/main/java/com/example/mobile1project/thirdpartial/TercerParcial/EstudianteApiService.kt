package com.example.mobile1project.thirdpartial.TercerParcial

import com.example.mobile1project.thirdpartial.TercerParcial.models.Estudiante
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EstudianteApiService {

    @GET("students.json") // Solo el nombre del archivo
    suspend fun getEstudiantes(): List<Estudiante>

    companion object {
        fun create(): EstudianteApiService {
            return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/ingjromo/2b6648feaf70d1116e6f468b263d73c9/raw/50cf034eb87e273d6746cf2ffb9afb5a409f80b2/") // <- nota el '/' al final
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EstudianteApiService::class.java)
        }
    }
}
