package com.example.catapi.presentation.adapter.vote

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.catapi.databinding.VoteItemBinding
import com.example.catapi.presentation.adapter.OnItemClickListener
import com.example.catapi.R

class VoteHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding=VoteItemBinding.bind(view)

    fun bind(item:VoteItem, onClick:(VoteItem)->Unit)= with(binding){
        tvVote.text=item.value
        imVote.load(item.imageUrl){
            crossfade(true)
            placeholder(R.drawable.fox)
            transformations(CircleCropTransformation())
        }
        cvVote.setOnClickListener {
            onClick(item)
        }
    }
}