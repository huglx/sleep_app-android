package com.hugl.sleepapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hugl.sleepapp.R
import com.hugl.sleepapp.databinding.ActivityMainBinding
import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.Resource
import com.hugl.sleepapp.ui.base.BaseActivity
import com.hugl.sleepapp.utils.ViewModelFactory
import com.hugl.sleepapp.utils.observe
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var bindings: ActivityMainBinding

    override fun initViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }

    override fun initBindings() {
        bindings = ActivityMainBinding.inflate(layoutInflater)
        val view = bindings.root
        setContentView(view)
    }

    override fun observeViewModel() {
        observe(viewModel.testLiveData,::test)
    }

    private fun test(resource: Resource<List<Test>>) {
        when (resource) {
            is Resource.Success -> resource.data?.let {
                it[0].contentType?.let { it1 -> Log.i("TAGdgsdg", it1) }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.initIntentData()

    }
}