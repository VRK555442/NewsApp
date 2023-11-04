package com.rk.newsapp.presentation.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.newsapp.domain.usecase.NewsUseCase
import com.rk.newsapp.presentation.StateHolder
import com.rk.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel(){
    val articles = mutableStateOf(StateHolder())
    init{
        getNewsArticles()
    }
    fun getNewsArticles() {
        newsUseCase().onEach() {
            when(it) {
                is Resource.Loading -> {
                    articles.value = StateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    articles.value = StateHolder(success = it.data)
                }
                is Resource.Error -> {
                    articles.value = StateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}