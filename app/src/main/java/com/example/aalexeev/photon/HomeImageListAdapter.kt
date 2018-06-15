package com.example.aalexeev.photon

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso

class HomeImageListAdapter(private val cardList: List<CardInfo>) :
    RecyclerView.Adapter<HomeImageListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImage: android.support.v7.widget.AppCompatImageView = itemView.findViewById(R.id.imageCard)
        val favoritImge : android.support.v7.widget.AppCompatImageView = itemView.findViewById(R.id.imageFavorit)
        val watchingImge : android.support.v7.widget.AppCompatImageView = itemView.findViewById(R.id.imageWatching)
        val countLike: TextView = itemView.findViewById(R.id.countFavoritLabel)
        val countWatch: TextView = itemView.findViewById(R.id.countWatchingLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): HomeImageListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.photocard_list_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(cardList[position].image).into(holder.cardImage)
        holder.countLike.text = cardList[position].countLike.toString()
        holder.countWatch.text = cardList[position].countWatch.toString()
    }

    override fun getItemCount() = cardList.size
}