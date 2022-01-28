package com.veda.virginmoney.data.remote

import com.veda.virginmoney.data.service.Resource
import retrofit2.Response

abstract class BaseNetworkResponse {

    protected suspend fun <T> getResponseData(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) return Resource.success(responseBody)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Failed to connect: $message")
    }

}