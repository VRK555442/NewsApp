package com.rk.newsapp.domain.repo

import com.rk.newsapp.domain.model.Article

interface NewsRepo {

    suspend fun getNewsArticles() : List<Article>
}