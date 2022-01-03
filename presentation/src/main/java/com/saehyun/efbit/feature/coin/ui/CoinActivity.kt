package com.saehyun.efbit.feature.coin.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.entity.coin.Market
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityCoinBinding
import com.saehyun.efbit.feature.coin.adapter.MainCoinAdapter
import com.saehyun.efbit.feature.coin.viewmodel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinActivity @Inject constructor(
): BaseActivity<ActivityCoinBinding>(
    R.layout.activity_coin
){

    private val data = arrayListOf<Market>()
    private val coinViewModel: CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coinViewModel.getCoin()

        setLayoutData()
        setRecyclerview()

        binding.rvCoinBack.setOnClickListener {
            finish()
        }
    }


    private fun setLayoutData() {
        binding.run {
            lifecycleOwner = this@CoinActivity
            viewModel = coinViewModel
            activity = this@CoinActivity
        }
    }

    private fun setRecyclerview() {
        binding.rvCoin.run {
            layoutManager = LinearLayoutManager(this@CoinActivity)
            setHasFixedSize(true)
            adapter = MainCoinAdapter(applicationContext, data)
        }
    }

    private fun setRecyclerviewData(data: CoinEntity) {
        for(i: Int in 1..data.markets.size-1) {
            this.data.add(data.markets.get(i))
        }
        binding.rvCoin.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        coinViewModel.run {
            data.observe(this@CoinActivity, {
                setRecyclerviewData(it)
            })

            errorMesssage.observe(this@CoinActivity, {
                showToast(it.toString())
            })
        }
    }
}