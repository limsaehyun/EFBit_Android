package com.saehyun.efbit.feature.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.domain.base.ErrorHandlerEntity
import com.saehyun.domain.entity.exchange.ExchangeEntity
import com.saehyun.domain.usecase.GetExchangeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getExchangeUseCase: GetExchangeUseCase
) : ViewModel() {
    val data = MutableLiveData<ExchangeEntity>()
    val errorMesssage = MutableLiveData<String>()

    fun getExchange() {
        viewModelScope.launch {
            try {
                getExchangeUseCase.execute(Unit).collect {
                    Log.d("Main", "getExchange: ")
                    data.value = it
                }
            } catch (e: ErrorHandlerEntity) {
                errorMesssage.value = e.sendMessage
                Log.d("Main", "getExchange: ")
            }

        }
    }
}