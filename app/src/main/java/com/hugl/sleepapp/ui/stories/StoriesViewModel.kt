package com.hugl.sleepapp.ui.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.Resource
import kotlinx.coroutines.flow.collect
import com.hugl.sleepapp.ui.base.BaseViewModel
import com.task.data.DataRepository
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class StoriesViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {
    val  testLiveData: LiveData<Resource<List<Test>>> get() = testLiveDataPrivate
    private val testLiveDataPrivate = MutableLiveData<Resource<List<Test>>>()
    fun initIntentData() {
    }

}