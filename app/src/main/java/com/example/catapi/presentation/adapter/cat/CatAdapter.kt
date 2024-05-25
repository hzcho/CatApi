package com.example.catapi.presentation.adapter.cat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catapi.R
import com.example.catapi.presentation.adapter.OnItemClickListener

class CatAdapter(
    private val onItemClickListener: OnItemClickListener<CatItem>
) : RecyclerView.Adapter<CatHolder>() {

    private var list = listOf<CatItem>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)

        return CatHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val currentItem = list[position]

        holder.bind(currentItem){item->
            onItemClickListener.onItemClick(item)
        }
    }

    fun setList(newList: List<CatItem>) {
        list = newList
        notifyDataSetChanged()
    }
}