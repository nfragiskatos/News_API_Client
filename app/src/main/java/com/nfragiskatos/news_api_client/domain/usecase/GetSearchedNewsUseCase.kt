package com.nfragiskatos.news_api_client.domain.usecase

import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.util.Resource
import com.nfragiskatos.news_api_client.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String) : Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}