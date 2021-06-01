package com.hugl.sleepapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity: AppCompatActivity() {
    protected abstract fun initViewModel()
    protected abstract fun initBindings()
    abstract fun observeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initBindings()
        initViewModel()
        observeViewModel()
    }
}