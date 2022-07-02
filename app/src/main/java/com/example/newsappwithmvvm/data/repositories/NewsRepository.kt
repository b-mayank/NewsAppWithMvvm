package com.example.newsappwithmvvm.data.repositories

import com.example.newsappwithmvvm.data.models.NewsResponse
import com.example.newsappwithmvvm.data.network.MyApi
import retrofit2.Call

class NewsRepository(
    private val api: MyApi
) {

    fun getNews(country: String, category: String, apiKey: String): Call<NewsResponse> {
        return api.getNews(country, category, apiKey)
    }
}
