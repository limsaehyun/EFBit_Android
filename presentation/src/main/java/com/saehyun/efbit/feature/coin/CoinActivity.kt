package com.saehyun.efbit.feature.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ActivityCoinBinding

class CoinActivity : BaseActivity<ActivityCoinBinding>(
    R.layout.activity_coin
){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeEvent() {
    }
}