package com.example.newsapplicationcompose.dataclasses

data class GetTopNewsHeadlines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)