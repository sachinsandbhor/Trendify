package com.shreejacreation.trendify.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.shreejacreation.trendify.data.Article
import com.shreejacreation.trendify.data.Source
import com.shreejacreation.trendify.presentation.ui.theme.TrendifyTheme

@Composable
fun TrendifyDetail(article: Article) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxWidth()
                    .height(250.dp),
                model = article.urlToImage,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
                    .background(Color.Black.copy(alpha = 0.3f), shape = CircleShape)

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = article.title,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = article.source.name,
                modifier = Modifier
                    .border(1.dp, Color.Blue, RoundedCornerShape(50))
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            Text(
                text = article.publishedAt,
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = article.content,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TrendifyDetailPreview() {
    TrendifyTheme {
        TrendifyDetail(
            Article(
                id = 1,
                author = "Emmy Sasipornkarn",
                content = "A cable linking two cabins snapped shortly before the deadly funicular crash in Lisbon this week, according to the first investigative report released Saturday. The report by Portugal's air and rail… [+2110 chars]",
                description = "Initial findings revealed that the funiculr accident occurred within 50 seconds. Officials called the deadly crash one of Lisbon's worst tragedies in recent memory.",
                publishedAt= "2025-09-07T10:01:13Z",
                source = Source(id = "null", name = "DW (English)"),
                title = "Lisbon funicular cable disconnected before crash — report - DW",
                url = "https://www.dw.com/en/lisbon-funicular-cable-disconnected-before-crash-report/a-73907543",
                urlToImage = "https://static.dw.com/image/73882594_6.jpg"
        ))
    }
}
