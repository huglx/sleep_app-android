package com.hugl.sleepapp.ui

import com.hugl.sleepapp.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {
    fun init():String{
        return "message from mainviewmodel"
    }
}