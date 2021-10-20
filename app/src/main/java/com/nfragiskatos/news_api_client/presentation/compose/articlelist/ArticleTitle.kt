package com.nfragiskatos.news_api_client.presentation.compose.articlelist

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.nfragiskatos.news_api_client.R
import com.nfragiskatos.news_api_client.data.model.Article

@Composable
fun ArticleTitle(article: Article) {
    Text(
        text = article.title.toString(), fontSize = 15.sp,
        color = colorResource(id = R.color.list_text),
        maxLines = 2, modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5
    )
}