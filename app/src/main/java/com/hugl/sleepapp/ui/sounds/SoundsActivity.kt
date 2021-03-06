package com.hugl.sleepapp.ui.sounds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugl.sleepapp.R
import com.hugl.sleepapp.databinding.ActivitySoundsBinding
import com.hugl.sleepapp.ui.base.BaseActivity
import com.hugl.sleepapp.ui.main.MainActivity
import com.hugl.sleepapp.ui.stories.StoriesActivity
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
        bottomNav()
    }

    private fun bottomNav(){
        bindings.bottomNavigation.menu.findItem(R.id.page_1).isChecked = true
        bindings.bottomNavigation.apply {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.page_2 -> {
                        startActivity(Intent(this@SoundsActivity, MainActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    R.id.page_1 -> {
                        false
                    }
                    R.id.page_3 -> {
                        startActivity(Intent(this@SoundsActivity, StoriesActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0);
                        true
                    }
                    else -> false
                }
            }
        }
    }
}