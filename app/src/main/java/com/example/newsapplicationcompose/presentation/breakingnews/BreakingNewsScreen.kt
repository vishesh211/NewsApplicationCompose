package com.example.newsapplicationcompose.presentation.breakingnews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.newsapplicationcompose.dataclasses.Article
import com.example.newsapplicationcompose.presentation.breakingnews.components.NewsItemCard
import com.example.newsapplicationcompose.viewmodel.NewsViewModel

@Composable
fun BreakingNewsScreen(viewModel: NewsViewModel) {
    viewModel.getTopArticles()
    var topArticles: List<Article>? = viewModel.topArticles.value

    if (topArticles.isNullOrEmpty()) topArticles = emptyList()
    LazyColumn {

        items(items = topArticles) {
            NewsItemCard(
                newsSource = it.source.name,
                newsHeadline = it.title,
                datePublished = it.publishedAt,
                isBookMarked =
            )
        }
    }
}