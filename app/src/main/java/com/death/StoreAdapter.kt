package com.death

import android.content.Context
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.rajora_sd.bottonnaviagtionbartutorial.R


/**
 * Created by rajora_sd on 12/26/2017.
 */
class StoreAdapter(private val context: Context, private val movieList: ArrayList<MoviesPojo>?) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.store_item_row, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movie = movieList!![position]
        holder.name.text = movie.title
        holder.price.text = movie.price

        Glide.with(context)
                .load(movie.image)
                .into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return movieList!!.size
    }
}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.title)
    var price: TextView = view.findViewById(R.id.price)
    var thumbnail: ImageView = view.findViewById(R.id.thumbnail)
}