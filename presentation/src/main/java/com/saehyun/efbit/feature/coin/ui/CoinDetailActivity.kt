package com.saehyun.efbit.feature.coin.ui

import android.content.ContentValues.TAG
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.domain.entity.coin.Market
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : BaseActivity<ActivityCoinDetailBinding> (
    R.layout.activity_coin_detail
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setData()

        binding.imageView.setOnClickListener {
            finish()
        }

    }

    override fun observeEvent() {
    }

    private fun setData() {
        val data = intent.getSerializableExtra("data") as Market

        binding.run {
            tvTitle.text = data.base_asset
            tvCoinSubName.text = data.symbol

            textView15.text = data.price.toString()
            tvCoinPercent.text = data.volume_24h.toString()

            tvCoin24HChanged.text = "%.2f".format(data.change_24h)

            tvCoinValue.text = data.volume_24h.toString()
        }
    }
}