package com.mohali.newsapp_virtusa.repository

import com.mohali.newsapp_virtusa.db.ArticleDao
import com.mohali.newsapp_virtusa.model.Article

import javax.inject.Inject

class LocaleRepository @Inject constructor(
    val db: com.mohali.newsapp_virtusa.db.ArticleDao
) : BaseRepository() {

    suspend fun insertNewsToDb(article: Article) = db.insertArticle(article)

    suspend fun deleteNews(article: Article) = db.deleteArticle(article)

    fun getSavedNews() = db.getSavedArticles()
}