package com.saehyun.efbit.feature.coin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.domain.base.ErrorHandlerEntity
import com.saehyun.domain.entity.coin.CoinEntity
import com.saehyun.domain.usecase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {
    val data = MutableLiveData<CoinEntity>()
    val errorMesssage = MutableLiveData<String>()

    fun getCoin() {
        viewModelScope.launch {
            try {
                getCoinUseCase.execute(Unit).collect {
                    data.value = it
                }
            } catch (e: ErrorHandlerEntity) {
                errorMesssage.value = e.sendMessage
            }

        }
    }
}