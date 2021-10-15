package com.nfragiskatos.news_api_client.data.repository.datasourceimpl

import com.nfragiskatos.news_api_client.data.db.ArticleDao
import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsLocalDataSource

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }
}