package com.saehyun.efbit.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(

) : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
){

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLayoutData()
    }

    private fun setLayoutData() {
        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
            activity = this@MainActivity
        }
    }

    override fun observeEvent() {
    }
}