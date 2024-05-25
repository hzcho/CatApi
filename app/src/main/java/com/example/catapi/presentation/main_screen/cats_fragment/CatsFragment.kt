package com.example.catapi.presentation.main_screen.cats_fragment

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
import com.example.catapi.databinding.FragmentCatsBinding
import com.example.catapi.presentation.adapter.cat.CatAdapter
import com.example.catapi.presentation.adapter.cat.CatItem
import com.example.domain.model.CatModel
import kotlinx.coroutines.launch

class CatsFragment : Fragment() {
    private val viewModel:CatsViewModel by activityViewModels()
    private lateinit var binding:FragmentCatsBinding
    private val adapter=CatAdapter(
        onItemClickListener = { item->
            viewModel.sendVote(item.id)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleScope.launch {
                viewModel.cats.collect{newList->
                    adapter.setList(newList.mapToCatItem())

                    srLayout.isRefreshing=false
                }
            }

            rvCats.adapter=adapter
            rvCats.layoutManager=LinearLayoutManager(activity)
            rvCats.addItemDecoration(
                DividerItemDecoration(activity, DividerItemDecoration.VERTICAL).apply {
                    setDrawable(resources.getDrawable(R.drawable.divider_margin, null))
                }
            )

            srLayout.setOnRefreshListener {
                viewModel.getCats()
            }
        }
    }

    private fun List<CatModel>.mapToCatItem():List<CatItem>{
        return this.map { catModel->
            CatItem(
                id =catModel.id,
                imageUrl =catModel.url
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CatsFragment()
    }
}