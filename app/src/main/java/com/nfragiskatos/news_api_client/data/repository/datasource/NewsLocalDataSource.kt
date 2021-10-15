package com.nfragiskatos.news_api_client.data.repository.datasource

import com.nfragiskatos.news_api_client.data.model.Article

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)
}