package com.example.newsapplicationcompose.presentation.breakingnews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.newsapplicationcompose.presentation.breakingnews.components.NewsItemCard
import com.example.newsapplicationcompose.viewmodel.NewsViewModel

@Composable
fun BreakingNewsScreen(viewModel: NewsViewModel) {
    viewModel.getTopArticles()
    val topArticles = viewModel.topArticles.value
    LazyColumn {
        items(items = topArticles) {
            NewsItemCard(
                newSource =
            )
        }
    }
}