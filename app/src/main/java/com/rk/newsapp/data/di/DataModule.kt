package com.rk.newsapp.data.di

import com.rk.newsapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun providesApiService() : ApiService {
        return Retrofit.Builder()
               .baseUrl("https://newsapi.org/v2/")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create(ApiService::class.java);

    }
}