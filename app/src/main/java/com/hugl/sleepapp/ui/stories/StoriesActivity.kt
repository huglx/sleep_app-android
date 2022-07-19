package com.hugl.sleepapp.ui.stories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.engine.Resource
import com.hugl.sleepapp.R
import com.hugl.sleepapp.databinding.ActivityStoriesBinding
import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.ui.base.BaseActivity
import com.hugl.sleepapp.ui.main.MainActivity
import com.hugl.sleepapp.ui.sounds.SoundsActivity
import com.hugl.sleepapp.utils.ViewModelFactory
import com.hugl.sleepapp.utils.observe
import dagger.android.AndroidInjection
import javax.inject.Inject

class StoriesActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: StoriesViewModel
    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var bindings: ActivityStoriesBinding
    override fun initViewModel() {
        viewModel = factory.create(StoriesViewModel::class.java)
    }

    override fun initBindings() {
        bindings = ActivityStoriesBinding.inflate(layoutInflater)
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
        bottomNav()
    }

    private fun bottomNav(){
        bindings.bottomNavigation.menu.findItem(R.id.page_3).isChecked = true
        bindings.bottomNavigation.apply {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.page_2 -> {
                        startActivity(Intent(this@StoriesActivity,MainActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    R.id.page_1 -> {
                        startActivity(Intent(this@StoriesActivity, SoundsActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    R.id.page_3 -> {
                        false
                    }
                    else -> false
                }
            }
        }
    }
}