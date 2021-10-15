package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.util.Resource
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int, searchQuery: String) : Resource<APIResponse> {
        return newsRepository.getSearchedNewsHeadlines(country, page, searchQuery)
    }
}