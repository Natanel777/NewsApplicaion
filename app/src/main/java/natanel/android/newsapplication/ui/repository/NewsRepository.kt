package natanel.android.newsapplication.ui.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import natanel.android.newsapplication.data.datasource.NewsDataSource
import natanel.android.newsapplication.data.entity.NewsResponse
import natanel.android.utilities.ResourceState
import retrofit2.Response
import javax.inject.Inject

//newsDataSource injected with help of providesNewDataSource (from AppModule)
class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {


    private var _flow : Flow<ResourceState<NewsResponse>>? = null
    val flow : Flow<ResourceState<NewsResponse>> get() = _flow!!

    fun loadNewsHeadlines(country: String) {
        _flow = getNewsHeadline(country)
    }

    //1.without flow's checks
//    suspend fun getNewsHeadline(country: String) : Response<NewsResponse>{
//        return newsDataSource.getNewsHeadline(country)
//    }

    //2.with flow's checks
     fun getNewsHeadline(country: String) : Flow<ResourceState<NewsResponse>> {
        //can achieve the same thing with mutableListOf<ResourceState<NewsResponse>>() but flow better
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            //from retrofit library
            if (response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some Error In Flow"))// localizedMessage(where you live)
        }
    }
}