package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute() : Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}