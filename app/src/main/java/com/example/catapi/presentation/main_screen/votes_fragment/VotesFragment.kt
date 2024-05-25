package com.example.catapi.presentation.main_screen.votes_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catapi.R
import com.example.catapi.databinding.FragmentVotesBinding
import com.example.catapi.presentation.adapter.vote.VoteAdapter
import com.example.catapi.presentation.adapter.vote.VoteItem
import com.example.domain.model.VoteModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class VotesFragment : Fragment() {
    private val viewModel:VotesViewModel by activityViewModels()
    private lateinit var binding: FragmentVotesBinding
    private val adapter=VoteAdapter(
        onItemClickListener = {item->

        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentVotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleScope.launch {
                viewModel.votes.collect{newList->
                    adapter.setList(newList.mapToVoteItems())
                    srLayout1.isRefreshing=false
                }
            }

            rvVotes.adapter=adapter
            rvVotes.layoutManager=LinearLayoutManager(activity)
            rvVotes.addItemDecoration(
                DividerItemDecoration(activity, DividerItemDecoration.VERTICAL).apply {
                    setDrawable(resources.getDrawable(R.drawable.divider_margin, null))
                }
            )

            srLayout1.setOnRefreshListener {
                viewModel.getVotes()
            }
        }
    }

    private fun List<VoteModel>.mapToVoteItems():List<VoteItem>{
        return this.map { voteModel->
            VoteItem(
                id =voteModel.id.toString(),
                imageUrl =voteModel.image.url,
                value =voteModel.value.toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = VotesFragment()
    }
}