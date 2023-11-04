package com.rk.newsapp.domain.usecase

import com.rk.newsapp.domain.model.Article
import com.rk.newsapp.domain.repo.NewsRepo
import com.rk.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val newsRepo : NewsRepo) {
    operator fun invoke() : Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading("Loading..."))
        try {
            emit(Resource.Success(newsRepo.getNewsArticles()))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message))
        }
    }
}