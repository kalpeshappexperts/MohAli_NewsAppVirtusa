package com.mohali.newsapp_virtusa.model


data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)