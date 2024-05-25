package com.example.catapi.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GetByPageParam
import com.example.domain.model.CatModel
import com.example.domain.model.SendVoteRequest
import com.example.domain.usecase.GetCatsByPage
import com.example.domain.usecase.GetSavedCatsUseCase
import com.example.domain.usecase.SendVoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatsByPage: GetCatsByPage,
    private val sendVoteUseCase: SendVoteUseCase,
    private val getSavedCatsUseCase: GetSavedCatsUseCase
) : ViewModel() {
    var cats = MutableStateFlow(emptyList<CatModel>())


}