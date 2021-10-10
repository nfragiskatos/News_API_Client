package com.nfragiskatos.news_api_client.data.repository.datasourceimpl

import com.nfragiskatos.news_api_client.data.api.NewsAPIService
import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}