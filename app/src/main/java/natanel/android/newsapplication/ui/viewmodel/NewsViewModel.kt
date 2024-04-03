package natanel.android.newsapplication.ui.viewmodel

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import natanel.android.newsapplication.data.AppConstants
import natanel.android.newsapplication.data.entity.NewsResponse
import natanel.android.newsapplication.ui.repository.NewsRepository
import natanel.android.utilities.ResourceState
import javax.inject.Inject

//in order to inject News ViewModel we need to add an @Inject to the constructor
//then we will be able use it in the HomeScreen() like we does
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    private val _news : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news : StateFlow<ResourceState<NewsResponse>> = _news

    init {
        //getNews(AppConstants.COUNTRY)
        getNewsDataFromSplashActivity()
    }

    private fun getNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest { newsResponse -> //collectLatest ensures that only the latest emission is processed
                    _news.value = newsResponse // updates news mutable auto(line 26)
                }
        }
    }

    private fun getNewsDataFromSplashActivity(){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.flow.collectLatest {newsResponse ->
                Log.d("newsRepository data3", newsResponse.toString())
                _news.value = newsResponse
            }
        }
    }

    private fun updateNewsData(newsResponse: ResourceState<NewsResponse>?){
        if (newsResponse != null) {
            _news.value = newsResponse
        }
    }

    companion object{
        const val TAG = "NewsViewModel"
    }
}