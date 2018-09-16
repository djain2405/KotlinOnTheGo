package com.example.divya.kotlinonthego.adapters

import android.content.Context
import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.divya.kotlinonthego.R
import com.example.divya.kotlinonthego.data.Category


class CategoryAdapter(val items : List<Category>, val context : Context)
    : RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {
            userTitleView.text = items[position].title
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val userTitleView : TextView = itemView.findViewById(R.id.title)
    }

}