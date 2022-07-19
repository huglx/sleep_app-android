package com.hugl.sleepapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugl.sleepapp.R
import com.hugl.sleepapp.databinding.ActivityMainBinding
import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.Resource
import com.hugl.sleepapp.ui.base.BaseActivity
import com.hugl.sleepapp.ui.sounds.SoundsActivity
import com.hugl.sleepapp.ui.stories.StoriesActivity
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

    private lateinit var adapter: FollowingItemsAdapter

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
                it.let { it1 -> adapter = FollowingItemsAdapter(it1)
                    bindings.list.adapter=adapter
                }
            }

            else -> {}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.initIntentData()
        bottomNav()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bindings.list.layoutManager = layoutManager
        bindings.list.setHasFixedSize(true)
    }

    private fun bottomNav(){
        bindings.bottomNavigation.menu.findItem(R.id.page_2).isChecked = true
        bindings.bottomNavigation.apply {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.page_2 -> {
                        // Respond to navigation item 1 click
                        false
                    }
                    R.id.page_1 -> {
                        startActivity(Intent(this@MainActivity,SoundsActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    R.id.page_3 -> {
                        startActivity(Intent(this@MainActivity,StoriesActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    else -> false
                }
            }
        }
    }
/*
    private fun bindListData(test: List<Test>) {
        adapter = FollowingItemsAdapter(test)
        bindings.list.adapter=adapter
    }*/


}