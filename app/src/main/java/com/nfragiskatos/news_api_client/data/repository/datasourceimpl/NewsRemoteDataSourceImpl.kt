package com.nfragiskatos.news_api_client.data.repository.datasourceimpl

import com.nfragiskatos.news_api_client.data.api.NewsAPIService
import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}