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
import kotlinx.android.synthetic.main.item_view.view.*

class RecycleAdapter(
    private var jokes: MutableList<Jokes>
) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(jokes: Jokes){
            itemView.tvId.text = jokes.id
            itemView.tvCreatedAt.text = jokes.created_at
            itemView.tvUpdatedAt.text = jokes.update_at
            itemView.tvValue.text = jokes.value
            itemView.tvUrl.text = jokes.url
            Glide.with(itemView).load(jokes.icon_url).into(itemView.tvIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        )
    }
    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.bindData(jokes.get(position))
   }

    override fun getItemCount(): Int = jokes.size

    fun appendData(list: List<Jokes>) {
        this.jokes.addAll(list)
        notifyItemRangeInserted(
            this.jokes.size,
            jokes.size - 1
        )
    }


}