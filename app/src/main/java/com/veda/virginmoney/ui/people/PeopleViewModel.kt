package com.veda.virginmoney.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veda.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val selectedPosition = MutableLiveData<Int>()
    val people = repository.getPeopleListData()
}