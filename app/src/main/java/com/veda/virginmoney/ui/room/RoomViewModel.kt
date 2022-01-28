package com.veda.virginmoney.ui.room

import androidx.lifecycle.ViewModel
import com.veda.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(repository: Repository) : ViewModel() {
    val room = repository.getRoomListData()
}