package com.example.catapi.presentation.main_screen.cats_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CatModel
import com.example.domain.model.GetByPageParam
import com.example.domain.model.SendVoteRequest
import com.example.domain.usecase.GetCatsByPage
import com.example.domain.usecase.GetSavedCatsUseCase
import com.example.domain.usecase.SendVoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val getCatsByPage: GetCatsByPage,
    private val getSavedCatsUseCase: GetSavedCatsUseCase,
    private val sendVoteUseCase: SendVoteUseCase
):ViewModel() {
    private val _cats=MutableStateFlow(listOf<CatModel>())
    val cats= _cats.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _cats.value=getSavedCatsUseCase(Unit)
        }
    }

    fun sendVote(imageId:String){
        viewModelScope.launch(Dispatchers.IO) {
            sendVoteUseCase(SendVoteRequest(image_id =imageId, sub_id ="0", value =1))
        }
    }

    fun getCats(){
        viewModelScope.launch(Dispatchers.IO) {
            _cats.value=getCatsByPage(
                GetByPageParam(limit =10, page =1)
            )
        }
    }
}