package com.example.catapi.presentation.main_screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.example.catapi.databinding.ActivityMainBinding
import com.example.catapi.presentation.adapter.cat.CatItem
import com.example.catapi.presentation.adapter.fragment_adapter.FragmentAdapter
import com.example.catapi.presentation.main_screen.cats_fragment.CatsFragment
import com.example.catapi.presentation.main_screen.votes_fragment.VotesFragment
import com.example.domain.model.CatModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentsWithTab = arrayOf(
        CatsFragment() to "cats",
        VotesFragment() to "votes"
    )
    private val fragmentAdapter = FragmentAdapter(
        fragmentActivity = this,
        fragments = fragmentsWithTab.map { it.first }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() = with(binding) {

        vpMain.adapter = fragmentAdapter

        TabLayoutMediator(tlMain, vpMain){tab, position->
            tab.text=fragmentsWithTab[position].second
        }.attach()
    }
}