package com.api.piclerick

import retrofit2.Response
import java.lang.Exception

data class ResponseHandler<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception?
){
    companion object{
        fun <T> success(data: Response<T>): ResponseHandler<T>{
            return ResponseHandler(
                status = Status.success,
                data = data,
                exception = null
            )
        }

        fun <T> failure(exception: Exception): ResponseHandler<T>{
            return ResponseHandler(
                status = Status.failure,
                data = null,
                exception = exception
            )
        }
    }

    sealed class Status{
        object success: Status()
        object failure: Status()
    }

    val failed: Boolean
        get() = this.status == Status.failure

    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true

    val body: T
        get() = this.data!!.body()!!
}
