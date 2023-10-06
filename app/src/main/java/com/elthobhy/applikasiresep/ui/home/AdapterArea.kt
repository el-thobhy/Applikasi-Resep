package com.elthobhy.applikasiresep.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.databinding.ItemAreaBinding
import com.elthobhy.applikasiresep.databinding.ItemMainBinding

class AdapterArea: ListAdapter<Domain, AdapterArea.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClicked(data: Domain)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(list: Domain){
            val binding = ItemAreaBinding.bind(itemView)
            binding.apply {
                tvAreaDialog.text = list.strArea
            }
            itemView.setOnClickListener {
                onItemClickCallback.onClicked(list)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_area, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Domain>(){
            override fun areItemsTheSame(oldItem: Domain, newItem: Domain): Boolean {
                return oldItem.strArea == newItem.strArea
            }

            override fun areContentsTheSame(oldItem: Domain, newItem: Domain): Boolean {
                return oldItem == newItem
            }

        }
    }
}