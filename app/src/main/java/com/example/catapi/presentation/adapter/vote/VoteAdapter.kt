package com.example.catapi.presentation.adapter.vote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catapi.presentation.adapter.OnItemClickListener
import com.example.catapi.R
import com.example.catapi.presentation.adapter.cat.CatItem

class VoteAdapter(
    private val onItemClickListener: OnItemClickListener<VoteItem>
):RecyclerView.Adapter<VoteHolder>() {
    private var list= listOf<VoteItem>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VoteHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.vote_item, parent, false)

        return VoteHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VoteHolder, position: Int) {
        val currentItem=list[position]

        holder.bind(currentItem){item->
            onItemClickListener.onItemClick(item)
        }
    }

    fun setList(newList: List<VoteItem>) {
        list = newList
        notifyDataSetChanged()
    }
}