package com.rk.newsapp.data.network

import com.rk.newsapp.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsArticles(@Query("country") country: String = "us",
    @Query("apikey") apikey: String = "0c8ae7d565dc45589367b37bf675e87d") : Response<NewsDTO>
}