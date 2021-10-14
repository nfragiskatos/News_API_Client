package com.nfragiskatos.news_api_client.presentation.di

import com.nfragiskatos.news_api_client.presentation.adapter.NewsAdapter
import com.nfragiskatos.news_api_client.presentation.viewmodel.NewsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideNewsAdapter() : NewsAdapter {
        return NewsAdapter()
    }
}