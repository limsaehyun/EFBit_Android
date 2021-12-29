package com.saehyun.efbit.feature.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saehyun.domain.entity.exchange.Exchange
import com.saehyun.efbit.R
import com.saehyun.efbit.databinding.ExchangeViewBinding

import android.net.Uri

import android.content.Intent
import java.lang.Math.round


class MainExchangeAdapter(
    val context: Context,
    val data: List<Exchange>
    ) : RecyclerView.Adapter<MainExchangeAdapter.Holder>() {

    private lateinit var binding: ExchangeViewBinding

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = DataBindingUtil.inflate<ExchangeViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.exchange_view, parent, false
        )
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = data.get(position)

        binding.run {
            tvCoin.text = data.exchange_id
            tvSubName.text = data.name
            val volume = "%.2f".format(data.volume_24h)
            tvExchangeValue.text = volume

            ivLink.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(data.website)
                )
                holder.itemView.context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}