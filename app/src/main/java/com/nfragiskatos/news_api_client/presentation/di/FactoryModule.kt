package com.nfragiskatos.news_api_client.presentation.di

import android.app.Application
import com.nfragiskatos.news_api_client.domain.usecase.GetNewsHeadlinesUseCase
import com.nfragiskatos.news_api_client.domain.usecase.GetSearchedNewsUseCase
import com.nfragiskatos.news_api_client.domain.usecase.SaveNewsUseCase
import com.nfragiskatos.news_api_client.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase, getSearchedNewsUseCase, saveNewsUseCase)
    }
}