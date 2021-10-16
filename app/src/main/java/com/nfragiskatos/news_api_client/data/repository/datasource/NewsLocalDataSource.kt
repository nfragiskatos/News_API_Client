package com.nfragiskatos.news_api_client.data.repository.datasource

import com.nfragiskatos.news_api_client.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles(): Flow<List<Article>>
}