package com.api.piclerick

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdData?{
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.failed){
            return null
        }

        if (!request.isSuccessful){
            return null
        }
        return request.body
    }

}
