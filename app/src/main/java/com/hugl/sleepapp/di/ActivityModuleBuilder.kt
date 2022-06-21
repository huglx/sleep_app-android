package com.hugl.sleepapp.di
import com.hugl.sleepapp.ui.main.MainActivity
import com.hugl.sleepapp.ui.sounds.SoundsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeSoundsActivity(): SoundsActivity

}
