package com.nfragiskatos.news_api_client.presentation.di

import com.nfragiskatos.news_api_client.data.db.ArticleDao
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsLocalDataSource
import com.nfragiskatos.news_api_client.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}