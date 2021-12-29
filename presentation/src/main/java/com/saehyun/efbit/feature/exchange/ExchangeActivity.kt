package com.saehyun.efbit.feature.exchange

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityExchangeBinding
import com.saehyun.efbit.feature.main.adapter.MainCoinAdapter
import com.saehyun.efbit.feature.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExchangeActivity @Inject constructor(
) : BaseActivity<ActivityExchangeBinding> (
    R.layout.activity_exchange
){

    private val data = arrayListOf<Exchange>()

    private val exchangeViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLayoutData()
        setRecyclerview()

        exchangeViewModel.getExchange()

        binding.ivExchangeBack.setOnClickListener {
            finish()
        }
    }

    private fun setLayoutData() {
        binding.run {
            lifecycleOwner = this@ExchangeActivity
            viewModel = exchangeViewModel
            activity = this@ExchangeActivity
        }
    }

    private fun setRecyclerview() {
        binding.run {
            binding.rvExchange.layoutManager = GridLayoutManager(this@ExchangeActivity, 2)
            binding.rvExchange.setHasFixedSize(true)
            binding.rvExchange.adapter= MainCoinAdapter(applicationContext, data)
        }
    }

    private fun setRecyclerviewData(data: ExchangeEntity) {
        for(i: Int in 1..data.exchanges.size-1) {
            this.data.add(data.exchanges.get(i))
        }
        binding.rvExchange.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        exchangeViewModel.run {
            data.observe(this@ExchangeActivity, {
                setRecyclerviewData(it)
            })

            errorMesssage.observe(this@ExchangeActivity, {
                showToast(it.toString())
            })
        }
    }
}