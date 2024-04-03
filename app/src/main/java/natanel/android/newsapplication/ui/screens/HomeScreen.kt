package natanel.android.newsapplication.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import natanel.android.newsapplication.ui.components.Loader
import natanel.android.newsapplication.ui.components.NewsRowComponent
import natanel.android.newsapplication.ui.viewmodel.NewsViewModel
import natanel.android.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {

    //whenever news changes it updates here in the UI thanks to collectAsState()
    val newsResponse by newsViewModel.news.collectAsState()

    var pageCount by remember {
        mutableIntStateOf(1)
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        pageCount // Page Count
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp

    ) { page: Int ->
        when (newsResponse) {

            is ResourceState.Success -> {
                val response =
                    (newsResponse as ResourceState.Success).data // getting inside the flow .data (its valid becasuse if condition is true it means it is ResourceState.Success and we can get the data)

                if (response.articles.isNotEmpty()) {
                    pageCount = response.articles.size
                    NewsRowComponent(page, response.articles[page])
                }
            }

            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Error -> {
                val error = (newsResponse as ResourceState.Error)
                Log.d(TAG, "Inside_Error $error")
            }


        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}