package com.rk.newsapp.presentation

import com.rk.newsapp.domain.model.Article

data class StateHolder(var isLoading: Boolean = false,
                       var success : List<Article>? = null,
                       var error : String = "")
