package com.elthobhy.applikasiresep.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.databinding.ItemSearchBinding

class AdapterFav: ListAdapter<DomainDetail, AdapterFav.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: DomainDetail)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(list: DomainDetail){
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
        val view = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DomainDetail>(){
            override fun areItemsTheSame(oldItem: DomainDetail, newItem: DomainDetail): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: DomainDetail, newItem: DomainDetail): Boolean {
                return oldItem == newItem
            }

        }
    }
}