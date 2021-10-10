package com.nfragiskatos.news_api_client.presentation.di

import com.nfragiskatos.news_api_client.data.api.NewsAPIService
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsRemoteDataSource
import com.nfragiskatos.news_api_client.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService) : NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}