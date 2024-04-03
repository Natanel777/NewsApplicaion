package natanel.android.newsapplication.data.datasource

import natanel.android.newsapplication.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.Query

interface NewsDataSource {

   suspend fun getNewsHeadline(country : String) : Response<NewsResponse>

}