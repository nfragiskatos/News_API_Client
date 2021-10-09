package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}