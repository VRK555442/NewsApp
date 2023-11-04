package com.rk.newsapp.domain.di

import com.rk.newsapp.data.network.ApiService
import com.rk.newsapp.data.repo.NewsRepoImpl
import com.rk.newsapp.domain.repo.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesNewsRepo(apiService: ApiService) : NewsRepo {
        return NewsRepoImpl(apiService)
    }
}