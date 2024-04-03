package natanel.android.newsapplication.data.datasource

import natanel.android.newsapplication.data.api.ApiService
import natanel.android.newsapplication.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

//we don't need to pass apiService its auto injected
//apiService injected  with help of providesApiService (from AppModule)
class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource{
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }

}