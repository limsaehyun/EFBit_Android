package com.saehyun.efbit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saehyun.efbit.R
import com.saehyun.efbit.feature.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startMain()
    }

    private fun startMain() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}