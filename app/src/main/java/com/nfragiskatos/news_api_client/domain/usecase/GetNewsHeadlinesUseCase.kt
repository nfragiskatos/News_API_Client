package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.util.Resource
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int) : Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}