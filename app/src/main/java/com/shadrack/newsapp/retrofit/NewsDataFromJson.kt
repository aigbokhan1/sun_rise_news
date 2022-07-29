package com.shadrack.newsapp.retrofit

import com.shadrack.newsapp.retrofit.Article

data class NewsDataFromJson(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)