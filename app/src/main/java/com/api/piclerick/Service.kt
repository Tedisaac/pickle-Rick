package com.api.piclerick

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("character/{character-id}")
    suspend fun getCharactersById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdData>
}