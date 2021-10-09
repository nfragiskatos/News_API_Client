package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}