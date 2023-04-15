package com.example.newsapplicationcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplicationcompose.dataclasses.Article
import com.example.newsapplicationcompose.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _topArticles: MutableLiveData<List<Article>> = MutableLiveData()
    val topArticles: LiveData<List<Article>>
        get() = _topArticles

    fun getTopArticles() {
        viewModelScope.launch{
            val response = newsRepository.getTopNewsHeadlines()
            if (response.isSuccessful) {
                _topArticles.value = response.body()?.articles
            }
        }
    }
}