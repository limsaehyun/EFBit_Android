package com.saehyun.efbit.feature.coin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saehyun.efbit.R
import android.content.Intent
import com.saehyun.domain.entity.coin.Market
import com.saehyun.efbit.databinding.CoinViewBinding
import com.saehyun.efbit.feature.coin.ui.CoinDetailActivity


class MainCoinAdapter(
    val context: Context,
    val data: List<Market>
    ) : RecyclerView.Adapter<MainCoinAdapter.Holder>() {

    private lateinit var binding: CoinViewBinding

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = DataBindingUtil.inflate<CoinViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.coin_view, parent, false
        )

        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = data.get(position)

        binding.run {
            tvCoinExchange.text = data.exchange_id
            tvCoinName.text = data.base_asset
            tvCoinPrice.text = "%.2f".format(data.price)
            tvCoinPercent.text = "%.2f".format(data.change_24h)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, CoinDetailActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data", data)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}