package com.example.newsapplicationcompose.repository

import com.example.newsapplicationcompose.api.NewsApi
import com.example.newsapplicationcompose.dataclasses.GetTopNewsHeadlines
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getTopNewsHeadlines(): Response<GetTopNewsHeadlines> {
        return newsApi.getTopNewsHeadlines()
    }
}