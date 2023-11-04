package com.rk.newsapp.data.repo

import com.rk.newsapp.convertor.toDomain
import com.rk.newsapp.data.network.ApiService
import com.rk.newsapp.domain.model.Article
import com.rk.newsapp.domain.repo.NewsRepo
import com.rk.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val apiService : ApiService) : NewsRepo,
    SafeApiRequest() {
    override suspend fun getNewsArticles(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticles() }
        return response?.articles?.toDomain()!!
    }
}