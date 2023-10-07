package com.elthobhy.applikasiresep.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.databinding.ItemMainBinding

class AdapterMain: ListAdapter<DomainMain, AdapterMain.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: DomainMain)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(list: DomainMain){
            val binding = ItemMainBinding.bind(itemView)
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DomainMain>(){
            override fun areItemsTheSame(oldItem: DomainMain, newItem: DomainMain): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: DomainMain, newItem: DomainMain): Boolean {
                return oldItem == newItem
            }

        }
    }
}