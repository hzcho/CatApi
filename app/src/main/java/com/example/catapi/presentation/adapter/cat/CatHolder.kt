package com.example.catapi.presentation.adapter.cat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.catapi.R
import com.example.catapi.databinding.CatItemBinding
import com.example.catapi.presentation.adapter.vote.VoteItem

class CatHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = CatItemBinding.bind(view)

    fun bind(item: CatItem, onClick:(CatItem)->Unit) = with(binding) {
        tvId.text = item.id
        ivCat.load(item.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.fox)
            transformations(CircleCropTransformation())
        }
        cvCat.setOnClickListener {
            onClick(item)
        }
    }
}