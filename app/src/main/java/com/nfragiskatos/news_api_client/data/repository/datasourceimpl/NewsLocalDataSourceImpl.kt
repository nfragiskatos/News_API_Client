package com.nfragiskatos.news_api_client.data.repository.datasourceimpl

import com.nfragiskatos.news_api_client.data.db.ArticleDao
import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticles(article: Article) {
        articleDao.deleteArticle(article)
    }


}