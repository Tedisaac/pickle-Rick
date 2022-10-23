package com.api.piclerick

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdData?{
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.isSuccessful){
            return request.body()!!
        }
        return null
    }

}
