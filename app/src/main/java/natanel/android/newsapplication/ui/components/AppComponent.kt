package natanel.android.newsapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import natanel.android.newsapplication.R
import natanel.android.newsapplication.data.entity.Article
import natanel.android.newsapplication.data.entity.NewsResponse
import natanel.android.newsapplication.data.entity.Source
import natanel.android.newsapplication.ui.theme.Orange

//Column disables default behaviour like CircularProgressIndicator taking full screen
@Composable
fun Loader() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Orange
        )
    }

}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextComponent(textValue = article.title ?: "-------")
        }
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color(0x40E7E7EC))
    ) {
        article.title
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_image_placeholder),
            error = painterResource(id = R.drawable.ic_image_placeholder)
        )
        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "No Available")
        AuthorDetailsComponent(article.source?.name)

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailsComponent(article.source?.name)
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun HeadingTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun AuthorText(textValue: String) {
    Text(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 8.dp),
        text = textValue,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily.Serif
    )
}

@Composable
fun AuthorDetailsComponent(name: String?) {
    Row(modifier = Modifier.fillMaxWidth()) {


        name?.also {
            AuthorText(it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NewsRowComponentPreview() {
    val article = Article(
        author = "Lauren Feiner",
        title = "Google agrees to destroy browsing data collected in Incognito mode - The Verge",
        content = "Google agrees to destroy browsing data collected in Incognito mode\r\nGoogle agrees to destroy browsing data collected in Incognito mode\r\n / Its part of a proposed class action settlement filed with a … [+2688 chars]",
        description = "The agreement is part of a proposed class action settlement filed with a California federal court in the case Brown v. Google.",
        publishedAt = "2024-04-01T17:33:35Z",
        source = Source(id = "the verge", name = "The Verge"),
        url = "https://www.theverge.com/2024/4/1/24117929/google-incognito-browsing-data-delete-class-action-settlement",
        urlToImage = "https://cdn.vox-cdn.com/thumbor/zoPORZsYcJT2WjI5lx7z45IV7As=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/24016886/STK093_Google_03.jpg"
    )

    NewsRowComponent(0, article)
}