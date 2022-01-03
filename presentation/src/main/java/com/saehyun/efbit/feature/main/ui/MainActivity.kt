package com.saehyun.efbit.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityMainBinding
import com.saehyun.efbit.databinding.CoinViewBinding
import com.saehyun.efbit.feature.coin.adapter.MainCoinAdapter
import com.saehyun.efbit.feature.coin.ui.CoinActivity
import com.saehyun.efbit.feature.coin.viewmodel.CoinViewModel
import com.saehyun.efbit.feature.exchange.ExchangeActivity
import com.saehyun.efbit.feature.main.adapter.MainExchangeAdapter
import com.saehyun.efbit.feature.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(
) : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
){

    private val exchangeData = arrayListOf<Exchange>()
    private val coinData = arrayListOf<Market>()

    private val mainViewModel: MainViewModel by viewModels()
    private val coinViewModel: CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLayoutData()

        setRecyclerview()

        mainViewModel.getExchange()
        coinViewModel.getCoin()

        binding.tvExchangeMore.setOnClickListener {
            startActivity(Intent(applicationContext, ExchangeActivity::class.java))
        }

        binding.tvMainCoinMore.setOnClickListener {
            startActivity(Intent(applicationContext, CoinActivity::class.java))
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
        binding.rvMainExchange.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter= MainExchangeAdapter(applicationContext, exchangeData)
        }

        binding.rvCoinMain.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter= MainCoinAdapter(applicationContext, coinData)
        }
    }

    private fun setExchangeRecyclerviewData(data: ExchangeEntity) {
        if(data.exchanges.size >= 4) {
            for(i: Int in 0..3) {
                exchangeData.add(data.exchanges.get(i))
            }
        }

        binding.rvMainExchange.adapter?.notifyDataSetChanged()
    }

    private fun setCoinRecyclerviewData(data: CoinEntity) {
        for(i: Int in 1..4) {
            coinData.add(data.markets.get(i))
        }
        binding.rvCoinMain.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        mainViewModel.run {
            data.observe(this@MainActivity, {
                setExchangeRecyclerviewData(it)
            })

            errorMesssage.observe(this@MainActivity, {
                showToast(it.toString())
            })
        }

        coinViewModel.run {
            data.observe(this@MainActivity, {
                setCoinRecyclerviewData(it)
            })
            errorMesssage.observe(this@MainActivity, {
                showToast(it.toString())
            })
        }
    }
}