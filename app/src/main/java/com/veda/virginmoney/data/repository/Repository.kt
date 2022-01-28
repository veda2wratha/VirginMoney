package com.veda.virginmoney.data.repository

import com.veda.virginmoney.data.remote.ApiData
import com.veda.virginmoney.data.service.callGetService

import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteData: ApiData
) {

    fun getRoomListData() = callGetService(
        networkCall = { remoteData.getRoomListData() }
    )

    fun getPeopleListData() = callGetService(
        networkCall = { remoteData.getPeopleListData() }
    )
}