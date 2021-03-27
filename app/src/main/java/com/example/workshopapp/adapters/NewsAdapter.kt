package com.example.workshopapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.R
import com.example.workshopapp.databinding.ItemNewsBinding

class NewsAdapter(var items:List<ArticlesItem?>?): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataBinding= DataBindingUtil.inflate<ItemNewsBinding>(
            LayoutInflater.from(parent.context),R.layout.item_news,parent,false)
        return ViewHolder(dataBinding)    }

    override fun getItemCount(): Int =items?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items?.get(position)
        if (item == null) return
        holder.dataBinding.content.text=item?.description
        holder.dataBinding.date.text=item?.publishedAt
        holder.dataBinding.title.text=item?.title
        holder.dataBinding.sourceName.text=item?.source?.name
        holder.dataBinding.image
        Glide.with(holder.dataBinding.image.context)
            .load(item.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.dataBinding.image)

    }
    fun changeData(newList:List<ArticlesItem?>?){
        this.items=newList
        notifyDataSetChanged()
    }
    class ViewHolder(val dataBinding: ItemNewsBinding): RecyclerView.ViewHolder(dataBinding.root)

}