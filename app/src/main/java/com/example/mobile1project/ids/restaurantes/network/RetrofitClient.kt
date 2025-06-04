package com.example.mobile1project.ids.restaurantes.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: RestauranteApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/jorgegit/f1c89ab2e409c98ec618fdb9e75077bd/raw/15e41a39c9c251cad31639feabf0ce4ba131bb19/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestauranteApiService::class.java)
    }
}
