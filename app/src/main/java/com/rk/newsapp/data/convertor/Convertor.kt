package com.rk.newsapp.data.convertor

import com.rk.newsapp.data.model.ArticleDTO
import com.rk.newsapp.domain.model.Article

fun List<ArticleDTO>.toDomain() : List<Article> {
    return map {
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            imgUrl = it.urlToImage?:""
        )
    }
}