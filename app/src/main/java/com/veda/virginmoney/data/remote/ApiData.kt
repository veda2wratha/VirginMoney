package com.veda.virginmoney.data.remote

import javax.inject.Inject

class ApiData @Inject constructor(private val apiService: ApiService): BaseNetworkResponse() {

    suspend fun getPeopleListData() = getResponseData { apiService.getPeopleList() }

    suspend fun getRoomListData() = getResponseData { apiService.getRoomList() }
}