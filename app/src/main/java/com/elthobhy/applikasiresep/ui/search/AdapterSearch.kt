package com.elthobhy.applikasiresep.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.databinding.ItemSearchBinding

class AdapterSearch: ListAdapter<DomainSearch, AdapterSearch.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: DomainSearch)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(list: DomainSearch){
            val binding = ItemSearchBinding.bind(itemView)
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DomainSearch>(){
            override fun areItemsTheSame(oldItem: DomainSearch, newItem: DomainSearch): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: DomainSearch, newItem: DomainSearch): Boolean {
                return oldItem == newItem
            }

        }
    }
}