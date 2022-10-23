package com.api.piclerick

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    private val moshi = Moshi.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi ))
        .build()

    private val service: Service by lazy {
        retrofit.create(Service::class.java)
    }

    val apiClient = ApiClient(service)
}