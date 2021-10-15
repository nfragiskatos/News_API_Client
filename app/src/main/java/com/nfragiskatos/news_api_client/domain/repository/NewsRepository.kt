package com.nfragiskatos.news_api_client.domain.repository

import com.nfragiskatos.news_api_client.data.model.APIResponse
import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNewsHeadlines(country: String, page: Int, searchQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}