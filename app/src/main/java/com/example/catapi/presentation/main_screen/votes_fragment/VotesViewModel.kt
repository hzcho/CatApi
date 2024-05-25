package com.example.catapi.presentation.main_screen.votes_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GetVotesRequest
import com.example.domain.model.VoteModel
import com.example.domain.usecase.GetVotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VotesViewModel @Inject constructor(
    private val getVotesUseCase: GetVotesUseCase
):ViewModel() {
    private val _votes = MutableStateFlow(emptyList<VoteModel>())
    val votes = _votes.asStateFlow()

    fun getVotes(){
        viewModelScope.launch(Dispatchers.IO) {
            _votes.value=getVotesUseCase(
                GetVotesRequest(sub_id = "0")
            )
        }
    }
}