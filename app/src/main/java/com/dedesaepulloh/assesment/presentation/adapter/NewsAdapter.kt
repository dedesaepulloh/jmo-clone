package com.dedesaepulloh.assesment.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dedesaepulloh.assesment.R
import com.dedesaepulloh.assesment.data.OtherNews

class NewsAdapter (private val listNews: ArrayList<OtherNews>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var desc: TextView = itemView.findViewById(R.id.tvDesc)
        var img: ImageView = itemView.findViewById(R.id.imgPoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val (userId, id, title, body) = listNews[position]
        holder.desc.text = title
        holder.img.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int = listNews.size
}