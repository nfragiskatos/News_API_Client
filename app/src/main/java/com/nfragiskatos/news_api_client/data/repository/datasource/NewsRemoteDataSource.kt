package com.nfragiskatos.news_api_client.data.repository.datasource

import com.nfragiskatos.news_api_client.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines() : Response<APIResponse>
}