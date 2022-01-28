package com.veda.virginmoney.data.remote

import com.veda.virginmoney.data.model.People
import com.veda.virginmoney.data.model.Room
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getPeopleList(): Response<List<People>>

    @GET("rooms")
    suspend fun getRoomList(): Response<List<Room>>

}