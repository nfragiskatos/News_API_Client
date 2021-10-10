package com.nfragiskatos.news_api_client.presentation.di

import com.nfragiskatos.news_api_client.data.repository.NewsRepositoryImpl
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsRemoteDataSource
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource) : NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}