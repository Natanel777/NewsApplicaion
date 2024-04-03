package natanel.android.newsapplication

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import natanel.android.newsapplication.data.entity.NewsResponse
import natanel.android.newsapplication.ui.navigation.AppNavigationGraph
import natanel.android.newsapplication.ui.repository.NewsRepository
import natanel.android.newsapplication.ui.theme.NewsApplicationTheme
import natanel.android.newsapplication.ui.viewmodel.NewsViewModel
import natanel.android.utilities.ResourceState
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsRepository: NewsRepository

    private val viewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //for checking
        lifecycleScope.launch{
            newsRepository.flow.collectLatest {
                Log.d("newsRepository2", it.toString())
            }
        }


        setContent {
            NewsApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    AppEntryPoint()
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}
