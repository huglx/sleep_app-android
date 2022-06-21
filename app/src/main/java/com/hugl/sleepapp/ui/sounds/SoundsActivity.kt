package com.hugl.sleepapp.ui.sounds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugl.sleepapp.databinding.ActivitySoundsBinding
import com.hugl.sleepapp.ui.base.BaseActivity
import com.hugl.sleepapp.utils.ViewModelFactory
import com.hugl.sleepapp.utils.observe
import dagger.android.AndroidInjection
import javax.inject.Inject

class SoundsActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: SoundsViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var bindings: ActivitySoundsBinding 
    
    override fun initViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }

    override fun initBindings() {
        bindings = ActivitySoundsBinding.inflate(layoutInflater)
        val view = bindings.root
        setContentView(view)
    }

    override fun observeViewModel() {
        observe(viewModel.testLiveData,::test)
    }

    private fun test(any: Any) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}