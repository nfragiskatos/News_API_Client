package com.nfragiskatos.news_api_client.data.api

import com.nfragiskatos.news_api_client.BuildConfig
import com.nfragiskatos.news_api_client.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,

        @Query("page")
        page: Int,

        @Query("apiKey")
        apiKey: String = BuildConfig.NEWS_API_KEY
    ) : Response<APIResponse>
}