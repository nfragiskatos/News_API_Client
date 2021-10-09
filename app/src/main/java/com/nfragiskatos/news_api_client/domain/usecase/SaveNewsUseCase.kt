package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}