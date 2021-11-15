package com.mohali.newsapp_virtusa.network

import com.mohali.newsapp_virtusa.model.NewsResponse
import com.mohali.newsapp_virtusa.util.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}