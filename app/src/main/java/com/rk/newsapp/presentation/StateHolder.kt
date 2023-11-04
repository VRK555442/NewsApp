package com.rk.newsapp.presentation

data class StateHolder(var isLoading: Boolean = false,
                       var success : String = "",
                       var error : String = "")
