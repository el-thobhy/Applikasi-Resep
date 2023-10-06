package com.elthobhy.applikasiresep.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.databinding.ItemCategoryBinding

class AdapterCategory: ListAdapter<DomainCategory, AdapterCategory.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: DomainCategory)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(list: DomainCategory){
            val binding = ItemCategoryBinding.bind(itemView)
            binding.apply {
                Glide.with(itemView)
                    .load(list.strCategoryThumb)
                    .into(imageMealCategory)
                tvCategoryName.text = list.strCategory
            }
            itemView.setOnClickListener {
                onItemClickCallback.onClicked(list)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DomainCategory>(){
            override fun areItemsTheSame(oldItem: DomainCategory, newItem: DomainCategory): Boolean {
                return oldItem.idCategory == newItem.idCategory
            }

            override fun areContentsTheSame(oldItem: DomainCategory, newItem: DomainCategory): Boolean {
                return oldItem == newItem
            }

        }
    }
}