package com.api.piclerick

import retrofit2.Response

class ApiClient(private  val service: Service) {

    suspend fun getCharacterById(characterId: Int): Response<GetCharacterByIdData>{
        return service.getCharactersById(characterId)
    }

}