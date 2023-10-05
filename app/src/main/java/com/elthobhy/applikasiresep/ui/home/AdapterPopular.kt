package com.elthobhy.applikasiresep.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainPopular
import com.elthobhy.applikasiresep.databinding.ItemPopularBinding

class AdapterPopular: ListAdapter<DomainPopular, AdapterPopular.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: DomainPopular)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(list: DomainPopular){
            val binding = ItemPopularBinding.bind(itemView)
            binding.apply {
                Glide.with(itemView)
                    .load(list.strMealThumb)
                    .into(imagePopular)
                tvMealName.text = list.strMeal
            }
            itemView.setOnClickListener {
                onItemClickCallback.onClicked(list)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DomainPopular>(){
            override fun areItemsTheSame(oldItem: DomainPopular, newItem: DomainPopular): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: DomainPopular, newItem: DomainPopular): Boolean {
                return oldItem == newItem
            }

        }
    }
}