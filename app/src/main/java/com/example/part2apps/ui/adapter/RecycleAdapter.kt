package com.example.part2apps.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.part2apps.R
import com.example.part2apps.data.model.Jokes
import com.example.part2apps.databinding.ItemViewBinding
import kotlinx.android.synthetic.main.item_view.view.*

class RecycleAdapter : RecyclerView.Adapter<MainViewHolder>(){
    var list = mutableListOf<Jokes>()
    fun setDataList(jokes: List<Jokes>){
        this.list = jokes.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val list = list[position]
        holder.binding.tvId.text = list.id
        holder.binding.tvCreatedAt.text = list.created_at
        holder.binding.tvUpdatedAt.text = list.update_at
        holder.binding.tvUrl.text = list.url
        holder.binding.tvValue.text = list.value
        Glide.with(holder.itemView.context).load(list.icon_url).into(holder.binding.tvIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent,false)
        return MainViewHolder(binding)
    }
}
class MainViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){}

