package com.example.newsappwithmvvm.data.models

import java.io.Serializable

data class NewsResponse(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
):Serializable

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
):Serializable{
    companion object{
        const val KEY_NEWS = "news_detail"
    }
}

data class Source(
    val id: String,
    val name: String
):Serializable
