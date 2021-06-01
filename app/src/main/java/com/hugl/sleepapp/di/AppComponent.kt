package com.hugl.sleepapp.di

import com.hugl.sleepapp.Application
import com.task.di.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ActivityModuleBuilder::class,
            AndroidInjectionModule::class,
            ViewModelModule::class,
            AppModule::class,
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: Application)
}
