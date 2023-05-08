package com.example.newsapplicationcompose.presentation.breakingnews.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsItemCard(
    onClick: () -> Unit,
    isBookMarked: Boolean,
    onToggleBookMark: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Column {
                NewsSource()
                Spacer(modifier = Modifier.height(12.dp))
                NewsHeadline()
                Spacer(modifier = Modifier.height(12.dp))
                NewsPublished()
            }
        }
    }
}