package com.task.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hugl.sleepapp.di.ViewModelKey
import com.hugl.sleepapp.ui.MainViewModel
import com.hugl.sleepapp.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Since dagger
 * support multibinding you are free to bind as may ViewModels as you want.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel:MainViewModel): ViewModel

}
