package com.saehyun.efbit.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityMainBinding
import com.saehyun.efbit.feature.exchange.ExchangeActivity
import com.saehyun.efbit.feature.main.adapter.MainCoinAdapter
import com.saehyun.efbit.feature.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(
) : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
){

    private val data = arrayListOf<Exchange>()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLayoutData()

        setRecyclerview()

        mainViewModel.getExchange()

        binding.tvExchangeMore.setOnClickListener {
            startActivity(Intent(applicationContext, ExchangeActivity::class.java))
        }
    }

    private fun setLayoutData() {
        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
            activity = this@MainActivity
        }
    }

    private fun setRecyclerview() {
        binding.run {
            binding.rvMainExchange.layoutManager = GridLayoutManager(this@MainActivity, 2)
            binding.rvMainExchange.setHasFixedSize(true)
            binding.rvMainExchange.adapter= MainCoinAdapter(applicationContext, data)
        }
    }

    private fun setRecyclerviewData(data: ExchangeEntity) {
        for(i: Int in 1..4) {
            this.data.add(data.exchanges.get(i))
        }
        binding.rvMainExchange.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        mainViewModel.run {
            data.observe(this@MainActivity, {
                setRecyclerviewData(it)
            })

            errorMesssage.observe(this@MainActivity, {
                showToast(it.toString())
            })
        }
    }
}