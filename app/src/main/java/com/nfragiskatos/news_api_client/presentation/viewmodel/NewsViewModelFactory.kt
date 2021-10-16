package com.nfragiskatos.news_api_client.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nfragiskatos.news_api_client.domain.usecase.GetNewsHeadlinesUseCase
import com.nfragiskatos.news_api_client.domain.usecase.GetSavedNewsUseCase
import com.nfragiskatos.news_api_client.domain.usecase.GetSearchedNewsUseCase
import com.nfragiskatos.news_api_client.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        ) as T
    }

}