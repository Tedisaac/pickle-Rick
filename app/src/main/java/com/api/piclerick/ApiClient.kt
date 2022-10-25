package com.api.piclerick

import retrofit2.Response

class ApiClient(private  val service: Service) {

    suspend fun getCharacterById(characterId: Int): ResponseHandler<GetCharacterByIdData>{
        return safeApiCall { service.getCharactersById(characterId) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): ResponseHandler<T>{
        return try {
            ResponseHandler.success(apiCall.invoke())
        }catch (e: Exception){
            ResponseHandler.failure(e)
        }
    }

}