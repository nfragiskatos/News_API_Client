package com.nfragiskatos.news_api_client.presentation.compose.articlelist

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.nfragiskatos.news_api_client.data.model.Article

@Composable
fun ArticleDescription(article: Article) {
    Text(
        text = article.description.toString(),
        style = MaterialTheme.typography.body1,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        color = Color.White
    )
}