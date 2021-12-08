package com.hugl.sleepapp.di

import com.hugl.sleepapp.Application
import com.hugl.sleepapp.Application.Companion.context
import com.hugl.sleepapp.utils.Network
import com.hugl.sleepapp.utils.NetworkConnectivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivity(): NetworkConnectivity {
        return Network(Application.context)
    }
}
