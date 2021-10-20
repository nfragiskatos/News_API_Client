package com.nfragiskatos.news_api_client.presentation.compose.articlelist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.nfragiskatos.news_api_client.R
import com.nfragiskatos.news_api_client.data.model.Article

@Composable
fun ArticleListItem(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(
            corner = CornerSize(5.dp),
        ),
        backgroundColor = colorResource(id = R.color.list_background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            ArticleTitle(article = article)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(2f)) {
                    ArticleImage(article = article)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                ) {
                    ArticleDescription(article = article)
                    Text(
                        text = article.publishedAt.toString().substringBefore("T"),
                        color = Color.White
                    )
                    Text(text = article.source?.name.toString(), color = Color.White)
                }

            }
        }

    }

}