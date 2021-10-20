package com.nfragiskatos.news_api_client.presentation.compose.articlelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.nfragiskatos.news_api_client.data.model.Article

@Composable
fun ArticleImage(article: Article) {
    Image(
        painter = rememberImagePainter(article.urlToImage, builder = {
            size(OriginalSize)
        }), null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxSize()
    )
}